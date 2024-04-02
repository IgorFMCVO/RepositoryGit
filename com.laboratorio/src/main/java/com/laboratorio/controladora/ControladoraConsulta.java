package com.laboratorio.controladora;

import static spark.Spark.*;
import com.laboratorio.modelo.Consulta;
import com.laboratorio.servico.ServicoConsulta;
import com.google.gson.Gson;

public class ControladoraConsulta {
    public ControladoraConsulta(ServicoConsulta servicoConsulta) {
        Gson gson = new Gson();

        get("/", (req, res) -> {
            res.redirect("/public");
            return null;
        });

        post("/consultas", (req, res) -> {
            Consulta consulta = gson.fromJson(req.body(), Consulta.class);
            servicoConsulta.adicionarConsulta(consulta);
            res.type("application/json");
            return gson.toJson("Consulta agendada com sucesso.");
        });

        get("/consultas", (req, res) -> {
            res.type("application/json");
            return gson.toJson(servicoConsulta.listarConsultas());
        });

        // Implemente as rotas para atualizar e cancelar consultas conforme necessário
    }
}
