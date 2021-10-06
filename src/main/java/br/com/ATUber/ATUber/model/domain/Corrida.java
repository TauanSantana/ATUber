package br.com.ATUber.ATUber.model.domain;

import br.com.ATUber.ATUber.model.auxiliar.Helpers;
import br.com.ATUber.ATUber.model.exceptions.ProdutoSemOrigemDestinoException;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Corrida")
public class Corrida extends Produto {
    public Corrida() {
    }
    public Corrida(String origem, String destino) {
        super(origem,destino);
    }

    public String getClima() {
        return clima;
    }


    public boolean isParadaNoCaminho() {
        return paradaNoCaminho;
    }

    public void setParadaNoCaminho(boolean paradaNoCaminho) {
        this.paradaNoCaminho = paradaNoCaminho;
    }

    public boolean isComAnimais() {
        return comAnimais;
    }

    public void setComAnimais(boolean comAnimais) {
        this.comAnimais = comAnimais;
    }


    String clima;
    boolean paradaNoCaminho;
    boolean comAnimais;

    
//    public Corrida(String origem, String destino) throws ProdutoSemOrigemDestinoException {
//        if (!origem.isEmpty() && !destino.isEmpty()) {
//            this.origem = origem;
//            this.destino = destino;
//        } else {
//            throw new ProdutoSemOrigemDestinoException("Os campos 'Origem' e 'Destino' são obrigatórios");
//        }
//    }
//
//    public Corrida(String origem, String destino, String clima, boolean paradaNoCaminho, boolean comAnimais) throws ProdutoSemOrigemDestinoException {
//        this(origem, destino);
//        this.clima = clima;
//        this.paradaNoCaminho = paradaNoCaminho;
//        this.comAnimais = comAnimais;
//    }

    public void CalcularValor() {
        if (this.getOrigem().toLowerCase().contains("rj") && this.getDestino().toLowerCase().contains("rj")) {
            this.setValor( 20.0F);
        } else {
            this.setValor(Helpers.gerarValorAleatorioProduto());
        }
    }
}
