package br.com.ATUber.ATUber.model.domain;

import br.com.ATUber.ATUber.model.auxiliar.Helpers;
import br.com.ATUber.ATUber.model.exceptions.EatsPreenchimentoIncompletoException;
import br.com.ATUber.ATUber.model.exceptions.ProdutoSemOrigemDestinoException;

public class Eats extends Produto {
    float peso;
    int qtdItens;
    boolean contemLiquido;

    public Eats(float peso, int qtdItens, String origem, String destino) throws EatsPreenchimentoIncompletoException, ProdutoSemOrigemDestinoException {
        if (peso != 0.0F && qtdItens != 0) {
            if (!origem.isEmpty() && !destino.isEmpty()) {
                this.peso = peso;
                this.qtdItens = qtdItens;
                this.origem = origem;
                this.destino = destino;
            } else {
                throw new ProdutoSemOrigemDestinoException("Os campos 'Origem' e 'Destino' são obrigatórios");
            }
        } else {
            throw new EatsPreenchimentoIncompletoException("Os campos 'Peso' e 'QtdItens' são obrigatórios");
        }
    }

    public Eats(float peso, int qtdItens, String origem, String destino, boolean contemLiquido) throws ProdutoSemOrigemDestinoException, EatsPreenchimentoIncompletoException {
        this(peso, qtdItens, origem, destino);
        this.contemLiquido = contemLiquido;
    }

    protected void CalcularValor() {
        if (this.qtdItens > 2 && this.peso > 500.0F) {
            this.valor = 5.0F;
        } else {
            this.valor = Helpers.gerarValorAleatorioProduto(2.0F, 10.0F);
        }

    }
}
