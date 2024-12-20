package com.example.demo.core.domain;

public class Cliente {

    private String idCliente;
    private String nome;
    private String cpf;
    private String email;
    private String dataCadastro;

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Cliente() {
    }

    public String getCpf() {
        if(cpf != null) {
            return cpf.replaceAll("\\D", "");
        }
        return null;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
