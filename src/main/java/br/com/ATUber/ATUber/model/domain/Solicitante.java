package br.com.ATUber.ATUber.model.domain;

import br.com.ATUber.ATUber.model.exceptions.SolicitantePreenchimentoIncompletoException;

public class Solicitante {
    private String nome;
    private String email;
    private String cpf;

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public Solicitante(String nome, String email, String cpf) throws SolicitantePreenchimentoIncompletoException {
        if (!nome.isEmpty() && !email.isEmpty() && !cpf.isEmpty()) {
            this.nome = nome;
            this.email = email;
            this.cpf = cpf;
        } else {
            throw new SolicitantePreenchimentoIncompletoException("Os campos 'Nome', 'Email' e 'CPF' são obrigatórios");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nome);
        sb.append(";");
        sb.append(this.email);
        return sb.toString();
    }
}
