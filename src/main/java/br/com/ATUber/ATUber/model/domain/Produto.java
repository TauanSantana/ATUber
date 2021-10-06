package br.com.ATUber.ATUber.model.domain;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public abstract class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isPago() {
        return pago;
    }

    private float valor;
    private String origem;
    private String destino;
    private boolean pago;

    public void setOrigem(String origem){
        this.origem = origem;
    }

    public String getOrigem(){
        return this.origem;
    }

    public void setDestino(String origem){
        this.origem = destino;
    }

    public String getDestino(){
        return this.destino;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Produto() {
    }

    public Produto(String origem, String destino) {
        this.origem = origem;
        this.destino = destino;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    protected abstract void CalcularValor();

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idSolicitante")
    public Solicitante solicitante;

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public Solicitante getSolicitante() {
        return this.solicitante;
    }
}
