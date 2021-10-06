package br.com.ATUber.ATUber.model.auxiliar;

public class CorridaModel {

    public String getClima() {
        return clima;
    }

    public boolean ParadaNoCaminho() {
        return paradaNoCaminho;
    }

    public void setParadaNoCaminho(boolean paradaNoCaminho) {
        this.paradaNoCaminho = paradaNoCaminho;
    }

    public boolean ComAnimais() {
        return comAnimais;
    }

    public void setComAnimais(boolean comAnimais) {
        this.comAnimais = comAnimais;
    }

    public void setOrigem(String origem){
        this.origem = origem;
    }

    public String getOrigem(){
        return this.origem;
    }

    public void setDestino(String destino){
        this.destino = destino;
    }
    public String getDestino(){
        return this.destino;
    }

    String clima;
    boolean paradaNoCaminho;
    boolean comAnimais;
    protected String origem;
    protected String destino;
}
