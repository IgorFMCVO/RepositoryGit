package com.laboratorio;

import static spark.Spark.*;

import com.google.gson.Gson;
import com.laboratorio.modelo.Cliente;
import com.laboratorio.modelo.Especialista;
import com.laboratorio.modelo.Consulta;
import com.laboratorio.servico.GestaoCadastros;
import com.laboratorio.servico.ServicoConsulta;

import laboratorioApi.ConsultaApi;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class App {
    public static void main(String[] args) {
        port(8080); // Configura a porta do servidor

        staticFiles.location("/public"); // A pasta de recursos estáticos dentro de 'src/main/resources'

        final GestaoCadastros gestaoCadastros = new GestaoCadastros();
        final ServicoConsulta servicoConsulta = new ServicoConsulta();

        // Integração da API de Consultas.
        new ConsultaApi(gestaoCadastros, servicoConsulta);

        post("/cadastro", (req, res) -> {
            String tipo = req.queryParams("tipo");
            String id = req.queryParams("id");
            String nome = req.queryParams("nome");
            String email = req.queryParams("email");
            
            if ("cliente".equals(tipo)) {
                String telefone = req.queryParams("telefone");
                Cliente novoCliente = new Cliente(id, nome, email, telefone);
                gestaoCadastros.adicionarCliente(novoCliente);
            } else if ("especialista".equals(tipo)) {
                String especialidade = req.queryParams("especialidade");
                Especialista novoEspecialista = new Especialista(id, nome, email, especialidade);
                gestaoCadastros.adicionarEspecialista(novoEspecialista);
            }

            res.type("text/html");
            return "<p>Cadastro realizado com sucesso!</p>";
        });

        get("/listar-cadastrados", (req, res) -> {
            Map<String, Object> todosCadastrados = new HashMap<>();
            todosCadastrados.put("clientes", gestaoCadastros.listarClientes().values());
            todosCadastrados.put("especialistas", gestaoCadastros.listarEspecialistas().values());
            
            res.type("application/json");
            return new Gson().toJson(todosCadastrados);
        });

        delete("/deletar-cadastrado/:id", (req, res) -> {
            String id = req.params(":id");
            if (gestaoCadastros.getCliente(id) != null) {
                gestaoCadastros.removerCliente(id);
            } else if (gestaoCadastros.getEspecialista(id) != null) {
                gestaoCadastros.removerEspecialista(id);
            } else {
                res.status(404); // Not Found
                return "Cadastrado não encontrado.";
            }
            return "Cadastrado deletado com sucesso!";
        });

        post("/agendar-consulta", (req, res) -> {
            // Os IDs, nomes, data e hora são coletados da requisição
            String clienteId = req.queryParams("cliente");
            String especialistaId = req.queryParams("especialista");
            String data = req.queryParams("data");
            String hora = req.queryParams("hora");

            // Aqui você precisa buscar os nomes do cliente e especialista baseado nos IDs
            String clienteNome = gestaoCadastros.getCliente(clienteId).getNome();
            String especialistaNome = gestaoCadastros.getEspecialista(especialistaId).getNome();

            // Agora, cria-se a nova consulta com todos os parâmetros necessários
            Consulta novaConsulta = new Consulta(UUID.randomUUID().toString(), clienteId, clienteNome, especialistaId, especialistaNome, data, hora);
            servicoConsulta.adicionarConsulta(novaConsulta);

            res.type("text/html");
            return "Consulta agendada com sucesso!";
        });

        get("/listar-consultas", (req, res) -> {
            res.type("application/json");
            return servicoConsulta.listarConsultas();
        });

        delete("/cancelar-consulta/:id", (req, res) -> {
            String id = req.params(":id");
            servicoConsulta.removerConsulta(id);
            return "Consulta cancelada com sucesso!";
        });
    }
}

