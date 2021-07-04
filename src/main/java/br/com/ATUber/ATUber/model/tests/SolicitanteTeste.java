package br.com.ATUber.ATUber.model.tests;

import br.com.ATUber.ATUber.model.domain.Solicitante;
import br.com.ATUber.ATUber.model.exceptions.SolicitantePreenchimentoIncompletoException;

public class SolicitanteTeste {
    public SolicitanteTeste() {
    }

    public static void main(String[] args) throws SolicitantePreenchimentoIncompletoException {
        new Solicitante("Tauan", "tauansantana@gmail.com", "77755533311");
    }
}
