package com.laboratorio.servico;

import com.laboratorio.modelo.Cliente;
import com.laboratorio.modelo.Especialista;
import java.util.HashMap;
import java.util.Map;

public class GestaoCadastros {
    private Map<String, Cliente> clientes = new HashMap<>();
    private Map<String, Especialista> especialistas = new HashMap<>();

    // Métodos para Clientes
    public void adicionarCliente(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

    public Cliente getCliente(String id) {
        return clientes.get(id);
    }

    public Map<String, Cliente> listarClientes() {
        return new HashMap<>(clientes);
    }

    public void removerCliente(String id) {
        clientes.remove(id);
    }

    public void atualizarCliente(String id, Cliente cliente) {
        clientes.put(id, cliente);
    }

    // Métodos para Especialistas
    public void adicionarEspecialista(Especialista especialista) {
        especialistas.put(especialista.getId(), especialista);
    }

    public Especialista getEspecialista(String id) {
        return especialistas.get(id);
    }

    public Map<String, Especialista> listarEspecialistas() {
        return new HashMap<>(especialistas);
    }

    public void removerEspecialista(String id) {
        especialistas.remove(id);
    }

    public void atualizarEspecialista(String id, Especialista especialista) {
        especialistas.put(id, especialista);
    }
}
