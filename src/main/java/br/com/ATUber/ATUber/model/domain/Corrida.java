package br.com.ATUber.ATUber.model.domain;

import br.com.ATUber.ATUber.model.auxiliar.Helpers;
import br.com.ATUber.ATUber.model.exceptions.ProdutoSemOrigemDestinoException;

public class Corrida extends Produto {
    String clima;
    boolean paradaNoCaminho;
    boolean comAnimais;

    public Corrida(String origem, String destino) throws ProdutoSemOrigemDestinoException {
        if (!origem.isEmpty() && !destino.isEmpty()) {
            this.origem = origem;
            this.destino = destino;
        } else {
            throw new ProdutoSemOrigemDestinoException("Os campos 'Origem' e 'Destino' são obrigatórios");
        }
    }

    public Corrida(String origem, String destino, String clima, boolean paradaNoCaminho, boolean comAnimais) throws ProdutoSemOrigemDestinoException {
        this(origem, destino);
        this.clima = clima;
        this.paradaNoCaminho = paradaNoCaminho;
        this.comAnimais = comAnimais;
    }

    protected void CalcularValor() {
        if (this.origem.toLowerCase().contains("rj") && this.destino.toLowerCase().contains("rj")) {
            this.valor = 20.0F;
        } else {
            this.valor = Helpers.gerarValorAleatorioProduto();
        }

    }
}
