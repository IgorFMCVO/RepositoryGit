package com.laboratorio.modelo;

public class Consulta {
    private String id;
    private String clienteId;
    private String especialistaId;
    private String clienteNome; // Adicionado
    private String especialistaNome; // Adicionado
    private String data;
    private String hora;

    // Construtor atualizado para incluir os nomes
    public Consulta(String id, String clienteId, String clienteNome, String especialistaId, String especialistaNome, String data, String hora) {
        this.id = id;
        this.clienteId = clienteId;
        this.clienteNome = clienteNome; // Inicializado
        this.especialistaId = especialistaId;
        this.especialistaNome = especialistaNome; // Inicializado
        this.data = data;
        this.hora = hora;
    }

    // Getters e setters atualizados para incluir os nomes
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getClienteId() {
        return clienteId;
    }
    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }
    public String getEspecialistaId() {
        return especialistaId;
    }
    public void setEspecialistaId(String especialistaId) {
        this.especialistaId = especialistaId;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    
    // Getters e setters adicionados para os nomes
    public String getClienteNome() {
        return clienteNome;
    }
    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }
    public String getEspecialistaNome() {
        return especialistaNome;
    }
    public void setEspecialistaNome(String especialistaNome) {
        this.especialistaNome = especialistaNome;
    }
}
