package br.com.ATUber.ATUber.model.domain;

import br.com.ATUber.ATUber.model.exceptions.PedidoSemDriverException;
import br.com.ATUber.ATUber.model.exceptions.PedidoSemProdutoException;
import br.com.ATUber.ATUber.model.exceptions.PedidoSemSolicitanteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pedido {
    private LocalDateTime dataPedido;
    private Solicitante solicitante;
    private Driver driver;
    private String descricao;
    private Produto produto;
    private boolean pedidoFechado;

    public Pedido() {
        this.pedidoFechado = false;
        this.dataPedido = LocalDateTime.now();
    }

    public Pedido(Solicitante solicitante, Driver driver) {
        this();
        this.solicitante = solicitante;
        this.driver = driver;
    }

    public Pedido(Solicitante solicitante, Driver driver, String descricao) {
        this();
        this.descricao = descricao;
        this.solicitante = solicitante;
        this.driver = driver;
    }

    public Pedido(Solicitante solicitante, Driver driver, Produto produto) {
        this();
        this.solicitante = solicitante;
        this.driver = driver;
        this.produto = produto;
    }

    public Pedido(Solicitante solicitante, Driver driver, Produto produto, LocalDateTime dataPedido) {
        this();
        this.solicitante = solicitante;
        this.driver = driver;
        this.produto = produto;
        this.dataPedido = dataPedido;
    }

    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        StringBuilder sb = new StringBuilder();
        String var10001 = this.produto.getClass().getSimpleName();
        sb.append(" Tipo Pedido: " + var10001);
        sb.append("\n Solicitado por: ");
        sb.append(this.solicitante.getNome());
        var10001 = dtf.format(this.dataPedido);
        sb.append("\n Em: " + var10001);
        sb.append("\n Entregue: ");
        sb.append(this.driver.getNome());
        sb.append("\n Situação do pedido: ");
        sb.append(this.pedidoFechado ? "Fechado" : "Pendente");
        sb.append(String.format("\n Valor Total: R$%.2f", this.produto.valor));
        return sb.toString();
    }

    public String fecharPedido() throws PedidoSemProdutoException, PedidoSemSolicitanteException, PedidoSemDriverException {
        if (this.produto == null) {
            throw new PedidoSemProdutoException("Não constam produtos no pedido!");
        } else if (this.solicitante == null) {
            throw new PedidoSemSolicitanteException("Não consta solicitante no pedido!");
        } else if (this.driver == null) {
            throw new PedidoSemDriverException("Não consta driver no pedido!");
        } else {
            this.produto.CalcularValor();
            this.produto.setPago(true);
            this.pedidoFechado = true;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            StringBuilder sb = new StringBuilder();
            sb.append(this.produto.getClass().getSimpleName());
            sb.append(";");
            sb.append(String.format("R$%.2f", this.produto.valor));
            sb.append(";");
            sb.append(this.produto.origem);
            sb.append(";");
            sb.append(this.produto.destino);
            sb.append(";");
            sb.append(this.solicitante.getNome());
            sb.append(";");
            sb.append(this.solicitante.getCpf());
            sb.append(";");
            sb.append(this.pedidoFechado ? "Fechado" : "Pendente");
            sb.append(";");
            sb.append(this.driver.getNome());
            sb.append(";");
            sb.append(dtf.format(this.dataPedido));
            sb.append(";");
            return sb.toString();
        }
    }
}
