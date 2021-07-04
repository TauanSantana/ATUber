package br.com.ATUber.ATUber.model.domain;

public class Driver {
    private String nome;
    private String email;
    private String telefone;
    private String tipoCarteira;

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getTipoCarteira() {
        return this.tipoCarteira;
    }

    public Driver(String nome, String email, String tipoCarteira) {
        this.nome = nome;
        this.email = email;
        this.tipoCarteira = tipoCarteira;
    }
}
