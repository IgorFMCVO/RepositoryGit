package laboratorioApi;

import com.google.gson.Gson;
import com.laboratorio.modelo.Cliente;

import com.laboratorio.servico.GestaoCadastros;
import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

public class CadastroApi {

    private static GestaoCadastros gestaoCadastros = new GestaoCadastros();

    public static void main(String[] args) {
        final Gson gson = new Gson();

        // Inicializações, se necessário
        port(4567);

        // Listar todos os clientes e especialistas
        get("/cadastros", (req, res) -> {
            Map<String, Object> todosCadastros = new HashMap<>();
            todosCadastros.put("clientes", gestaoCadastros.listarClientes());
            todosCadastros.put("especialistas", gestaoCadastros.listarEspecialistas());
            res.type("application/json");
            return gson.toJson(todosCadastros);
        });

        // Exemplo de endpoint para adicionar um cliente
        post("/cadastros/cliente", (req, res) -> {
            Cliente cliente = gson.fromJson(req.body(), Cliente.class);
            gestaoCadastros.adicionarCliente(cliente);
            res.status(201); // 201 Created
            return "Cliente cadastrado com sucesso";
        });

        // Exemplo de endpoint para remover um cliente
        delete("/cadastros/cliente/:id", (req, res) -> {
            String id = req.params(":id");
            gestaoCadastros.removerCliente(id);
            return "Cliente removido com sucesso";
        });

        // Semelhante para especialistas...
    }
}
