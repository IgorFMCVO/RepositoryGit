package laboratorioApi;

import com.google.gson.Gson;
import com.laboratorio.modelo.Consulta;
import com.laboratorio.servico.GestaoCadastros;
import com.laboratorio.servico.ServicoConsulta;

import java.util.UUID;

import static spark.Spark.post;
import static spark.Spark.get;
import static spark.Spark.delete;

public class ConsultaApi {
    public ConsultaApi(GestaoCadastros gestaoCadastros, ServicoConsulta servicoConsulta) {
        Gson gson = new Gson();

        post("/agendar-consulta", (req, res) -> {
            String clienteId = req.queryParams("cliente");
            String especialistaId = req.queryParams("especialista");
            String data = req.queryParams("data");
            String hora = req.queryParams("hora");
            String consultaId = UUID.randomUUID().toString();

            // Buscar os nomes do cliente e do especialista usando os IDs
            String clienteNome = gestaoCadastros.getCliente(clienteId).getNome();
            String especialistaNome = gestaoCadastros.getEspecialista(especialistaId).getNome();

            // Verifica se cliente e especialista existem
            if (clienteNome == null || especialistaNome == null) {
                res.status(404); // Not Found
                return gson.toJson("Cliente ou especialista não encontrado.");
            }

            // Ajustar a chamada ao construtor com os nomes
            Consulta novaConsulta = new Consulta(consultaId, clienteId, clienteNome, especialistaId, especialistaNome, data, hora);
            servicoConsulta.adicionarConsulta(novaConsulta);

            res.type("application/json");
            return gson.toJson("Consulta agendada com sucesso!");
        });

        get("/listar-consultas", (req, res) -> {
            res.type("application/json");
            return gson.toJson(servicoConsulta.listarConsultas());
        });

        delete("/cancelar-consulta/:id", (req, res) -> {
            String id = req.params(":id");
            boolean consultaRemovida = servicoConsulta.removerConsulta(id);
            if (!consultaRemovida) {
                res.status(404); // Not Found
                return gson.toJson("Consulta não encontrada para cancelamento.");
            }
            return gson.toJson("Consulta cancelada com sucesso!");
        });
    }
}
