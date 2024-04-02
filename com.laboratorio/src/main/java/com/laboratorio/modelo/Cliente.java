package com.laboratorio.modelo;

public class Cliente extends Pessoa {
    private String telefone;

    public Cliente(String id, String nome, String email, String telefone) {
        super(id, nome, email);
        this.telefone = telefone;
    }

    // Getter e Setter para telefone
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
