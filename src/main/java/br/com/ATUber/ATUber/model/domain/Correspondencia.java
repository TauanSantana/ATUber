package br.com.ATUber.ATUber.model.domain;

import br.com.ATUber.ATUber.model.auxiliar.Helpers;
import br.com.ATUber.ATUber.model.exceptions.CorrespondenciaPreenchimentoIncompletoException;
import br.com.ATUber.ATUber.model.exceptions.ProdutoSemOrigemDestinoException;

public class Correspondencia extends Produto {
    private float peso;
    private float largura;
    private float altura;
    private float profundidade;

    public Correspondencia(float peso, float largura, float altura, float profundidade, String origem, String destino) throws CorrespondenciaPreenchimentoIncompletoException, ProdutoSemOrigemDestinoException {
        if (peso <= 0.0F) {
            throw new CorrespondenciaPreenchimentoIncompletoException("Peso é um campo obrigatório e não pode ser menor ou igual 0");
        } else if (!origem.isEmpty() && !destino.isEmpty()) {
            this.peso = peso;
            this.largura = largura;
            this.altura = altura;
            this.profundidade = profundidade;
            this.origem = origem;
            this.destino = destino;
        } else {
            throw new ProdutoSemOrigemDestinoException("Os campos 'Origem' e 'Destino' são obrigatórios");
        }
    }

    protected void CalcularValor() {
        if (this.peso < 0.8F) {
            this.valor = 12.0F;
        } else {
            this.valor = Helpers.gerarValorAleatorioProduto();
        }

    }
}
