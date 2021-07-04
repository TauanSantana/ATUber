package br.com.ATUber.ATUber.model.exceptions;

public class PedidoSemProdutoException extends Exception {
    public PedidoSemProdutoException(String mensagem) {
        super(mensagem);
    }
}
