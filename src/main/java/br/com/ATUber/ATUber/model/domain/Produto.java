package br.com.ATUber.ATUber.model.domain;

public abstract class Produto {
    protected float valor;
    protected String origem;
    protected String destino;
    protected boolean pago;

    public Produto() {
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    protected abstract void CalcularValor();
}
