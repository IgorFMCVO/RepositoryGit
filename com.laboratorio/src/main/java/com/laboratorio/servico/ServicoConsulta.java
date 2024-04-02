package com.laboratorio.servico;

import com.laboratorio.modelo.Consulta;
import java.util.HashMap;
import java.util.Map;

public class ServicoConsulta {
    private Map<String, Consulta> consultas = new HashMap<>();

    public void adicionarConsulta(Consulta consulta) {
        consultas.put(consulta.getId(), consulta);
    }

    public Consulta getConsulta(String id) {
        return consultas.get(id);
    }

    public Map<String, Consulta> listarConsultas() {
        return consultas;
    }

    public boolean removerConsulta(String id) {
        if (consultas.containsKey(id)) {
            consultas.remove(id);
            return true; // Retorna true se a consulta foi removida
        }
        return false; // Retorna false se não encontrou a consulta para remover
    }
}
