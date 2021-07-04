package br.com.ATUber.ATUber.model.tests;

import br.com.ATUber.ATUber.model.domain.Correspondencia;
import br.com.ATUber.ATUber.model.domain.Corrida;
import br.com.ATUber.ATUber.model.domain.Driver;
import br.com.ATUber.ATUber.model.domain.Eats;
import br.com.ATUber.ATUber.model.domain.Pedido;
import br.com.ATUber.ATUber.model.domain.Produto;
import br.com.ATUber.ATUber.model.domain.Solicitante;
import br.com.ATUber.ATUber.model.exceptions.CorrespondenciaPreenchimentoIncompletoException;
import br.com.ATUber.ATUber.model.exceptions.EatsPreenchimentoIncompletoException;
import br.com.ATUber.ATUber.model.exceptions.PedidoSemDriverException;
import br.com.ATUber.ATUber.model.exceptions.PedidoSemProdutoException;
import br.com.ATUber.ATUber.model.exceptions.PedidoSemSolicitanteException;
import br.com.ATUber.ATUber.model.exceptions.ProdutoSemOrigemDestinoException;
import br.com.ATUber.ATUber.model.exceptions.SolicitantePreenchimentoIncompletoException;

public class PedidoTeste {
    public PedidoTeste() {
    }

    public static void main(String[] args) {
        Driver driver = new Driver("João Motorista", "joaomotorista@gmail.com", "B");

        Solicitante solicitante;
        Corrida produto;
        Pedido pedido;
        try {
            solicitante = new Solicitante("Tauan Santana", "tauansantana@gmail.com", "13945678900");
            produto = new Corrida("Petrópolis/RJ", "Glória/RJ");
            pedido = new Pedido(solicitante, driver, produto);
            pedido.fecharPedido();
            System.out.println(pedido.toString());
        } catch (PedidoSemSolicitanteException | PedidoSemDriverException | ProdutoSemOrigemDestinoException | SolicitantePreenchimentoIncompletoException | PedidoSemProdutoException var14) {
            System.out.println(var14.getMessage());
        }

        System.out.println("--------------");

        try {
            solicitante = new Solicitante("Tauan Santana", "tauansantana@gmail.com", "13945678900");
            produto = new Corrida("Petrópolis/RJ", "São Paulo/SP");
            pedido = new Pedido(solicitante, driver, produto);
            pedido.fecharPedido();
            System.out.println(pedido.toString());
        } catch (PedidoSemSolicitanteException | PedidoSemDriverException | ProdutoSemOrigemDestinoException | SolicitantePreenchimentoIncompletoException | PedidoSemProdutoException var13) {
            System.out.println(var13.getMessage());
        }

        System.out.println("--------------");

        Correspondencia produtoCorrespondencia2;
        try {
            solicitante = new Solicitante("Tauan Santana", "tauansantana@gmail.com", "13945678900");
            produtoCorrespondencia2 = new Correspondencia(900.0F, 50.0F, 50.0F, 5.0F, "21361260", "21361260");
            pedido = new Pedido(solicitante, driver, produtoCorrespondencia2);
            pedido.fecharPedido();
            System.out.println(pedido.toString());
        } catch (PedidoSemSolicitanteException | PedidoSemDriverException | ProdutoSemOrigemDestinoException | CorrespondenciaPreenchimentoIncompletoException | SolicitantePreenchimentoIncompletoException | PedidoSemProdutoException var12) {
            System.out.println(var12.getMessage());
        }

        System.out.println("--------------");

        try {
            solicitante = new Solicitante("Tauan Santana", "tauansantana@gmail.com", "13945678900");
            produtoCorrespondencia2 = new Correspondencia(500.0F, 50.0F, 50.0F, 5.0F, "21361260", "21361260");
            pedido = new Pedido(solicitante, driver, produtoCorrespondencia2);
            pedido.fecharPedido();
            System.out.println(pedido.toString());
        } catch (PedidoSemSolicitanteException | PedidoSemDriverException | ProdutoSemOrigemDestinoException | CorrespondenciaPreenchimentoIncompletoException | SolicitantePreenchimentoIncompletoException | PedidoSemProdutoException var11) {
            System.out.println(var11.getMessage());
        }

        System.out.println("--------------");


        try {
            solicitante = new Solicitante("Tauan Santana", "tauansantana@gmail.com", "13945678900");
            Eats produto2 = new Eats(600.0F, 3, "Nova Iguaçu/RJ", "Botafogo/RJ");
            pedido = new Pedido(solicitante, driver, produto2);
            pedido.fecharPedido();
            System.out.println(pedido.toString());
        } catch (PedidoSemSolicitanteException | PedidoSemDriverException | ProdutoSemOrigemDestinoException | EatsPreenchimentoIncompletoException | SolicitantePreenchimentoIncompletoException | PedidoSemProdutoException var10) {
            System.out.println(var10.getMessage());
        }

        System.out.println("--------------");

        try {
            solicitante = new Solicitante("Tauan Santana", "tauansantana@gmail.com", "13945678900");
            Eats produto3 = new Eats(500.0F, 5, "Nova Iguaçu/RJ", "Botafogo/RJ");
            pedido = new Pedido(solicitante, driver, produto3);
            pedido.fecharPedido();
            System.out.println(pedido.toString());
        } catch (PedidoSemSolicitanteException | PedidoSemDriverException | ProdutoSemOrigemDestinoException | EatsPreenchimentoIncompletoException | SolicitantePreenchimentoIncompletoException | PedidoSemProdutoException var9) {
            System.out.println(var9.getMessage());
        }

        System.out.println("--------------");
        System.out.println("Execuções com exception");
        System.out.println("--------------");
        System.out.println("Pedido sem Produto");

        try {
            solicitante = new Solicitante("Tauan Santana", "tauansantana@gmail.com", "13945678900");
            Pedido p7 = new Pedido(solicitante, driver, (Produto)null);
            p7.fecharPedido();
            System.out.println(p7.toString());
        } catch (PedidoSemSolicitanteException | PedidoSemDriverException | SolicitantePreenchimentoIncompletoException | PedidoSemProdutoException var8) {
            System.out.println("Erro: " + var8.getMessage());
        }

        System.out.println("--------------");
        System.out.println("Correspondencia sem Peso");

        try {
            solicitante = new Solicitante("Tauan Santana", "tauansantana@gmail.com", "13945678900");
            new Correspondencia(0.0F, 0.0F, 0.0F, 0.0F, "21361260", "26361230");
            pedido = new Pedido(solicitante, driver, (Produto)null);
            pedido.fecharPedido();
            System.out.println(pedido.toString());
        } catch (PedidoSemSolicitanteException | PedidoSemDriverException | ProdutoSemOrigemDestinoException | SolicitantePreenchimentoIncompletoException | CorrespondenciaPreenchimentoIncompletoException | PedidoSemProdutoException var7) {
            System.out.println("Erro: " + var7.getMessage());
        }

        System.out.println("--------------");
        System.out.println("Corrida sem Destino");

        try {
            solicitante = new Solicitante("Tauan Santana", "tauansantana@gmail.com", "13945678900");
            Corrida produto4 = new Corrida("Irajá/RJ", "");
            pedido = new Pedido(solicitante, driver, produto4);
            pedido.fecharPedido();
            System.out.println(pedido.toString());
        } catch (PedidoSemSolicitanteException | PedidoSemDriverException | SolicitantePreenchimentoIncompletoException | ProdutoSemOrigemDestinoException | PedidoSemProdutoException var6) {
            System.out.println("Erro: " + var6.getMessage());
        }

        System.out.println("--------------");
        System.out.println("Eats sem peso");

        try {
            solicitante = new Solicitante("Tauan Santana", "tauansantana@gmail.com", "13945678900");
            Eats produto5 = new Eats(0.0F, 2, "Nova Iguaçu/RJ", "Botafogo/RJ");
            pedido = new Pedido(solicitante, driver, produto5);
            pedido.fecharPedido();
            System.out.println(pedido.toString());
        } catch (PedidoSemSolicitanteException | PedidoSemDriverException | ProdutoSemOrigemDestinoException | SolicitantePreenchimentoIncompletoException | EatsPreenchimentoIncompletoException | PedidoSemProdutoException var5) {
            System.out.println("Erro: " + var5.getMessage());
        }

        System.out.println("--------------");
    }
}
