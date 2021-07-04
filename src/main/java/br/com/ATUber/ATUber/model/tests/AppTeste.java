package br.com.ATUber.ATUber.model.tests;

import br.com.ATUber.ATUber.model.domain.Correspondencia;
import br.com.ATUber.ATUber.model.domain.Corrida;
import br.com.ATUber.ATUber.model.domain.Driver;
import br.com.ATUber.ATUber.model.domain.Eats;
import br.com.ATUber.ATUber.model.domain.Pedido;
import br.com.ATUber.ATUber.model.domain.Solicitante;
import br.com.ATUber.ATUber.model.exceptions.CorrespondenciaPreenchimentoIncompletoException;
import br.com.ATUber.ATUber.model.exceptions.EatsPreenchimentoIncompletoException;
import br.com.ATUber.ATUber.model.exceptions.PedidoSemDriverException;
import br.com.ATUber.ATUber.model.exceptions.PedidoSemProdutoException;
import br.com.ATUber.ATUber.model.exceptions.PedidoSemSolicitanteException;
import br.com.ATUber.ATUber.model.exceptions.ProdutoSemOrigemDestinoException;
import br.com.ATUber.ATUber.model.exceptions.SolicitantePreenchimentoIncompletoException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.core.io.ClassPathResource;

public class AppTeste {
    public AppTeste() {
    }

    public static void main(String[] args) throws IOException {
        try {
            String dir = System.getProperty("user.dir");
            LocalDateTime var10000 = LocalDateTime.now();
            String arq = var10000.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".txt";
            InputStream resource = (new ClassPathResource("static/pedidos.txt")).getInputStream();
            FileWriter fileW = new FileWriter(dir + arq);
            BufferedWriter escrita = new BufferedWriter(fileW);
            BufferedReader leitura = new BufferedReader(new InputStreamReader(resource));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            for(String linha = leitura.readLine(); linha != null; linha = leitura.readLine()) {
                String[] campos = linha.split(";");
                String var10 = campos[0];
                byte var11 = -1;
                switch(var10.hashCode()) {
                    case -1675145382:
                        if (var10.equals("Corrida")) {
                            var11 = 1;
                        }
                        break;
                    case -433324957:
                        if (var10.equals("Correspondencia")) {
                            var11 = 0;
                        }
                        break;
                    case 2152507:
                        if (var10.equals("Eats")) {
                            var11 = 2;
                        }
                }

                switch(var11) {
                    case 0:
                        Correspondencia correspondencia = new Correspondencia(Float.valueOf(campos[1]), Float.valueOf(campos[2]), Float.valueOf(campos[3]), Float.valueOf(campos[4]), campos[5], campos[6]);
                        Solicitante solicitante = new Solicitante(campos[7], campos[8], campos[9]);
                        Driver driver = new Driver(campos[10], campos[11], campos[12]);
                        Pedido pedido = new Pedido(solicitante, driver, correspondencia, LocalDateTime.parse(campos[13], formatter));
                        escrita.write(pedido.fecharPedido() + "\r\n");
                        break;
                    case 1:
                        Corrida corrida = new Corrida(campos[1], campos[2]);
                        Solicitante solicitante2 = new Solicitante(campos[3], campos[4], campos[5]);
                        Driver driver2 = new Driver(campos[6], campos[7], campos[8]);
                        Pedido pedido2 = new Pedido(solicitante2, driver2, corrida, LocalDateTime.parse(campos[9], formatter));
                        escrita.write(pedido2.fecharPedido() + "\r\n");
                        break;
                    case 2:
                        Eats eats = new Eats(Float.valueOf(campos[1]), Integer.valueOf(campos[2]), campos[3], campos[4]);
                        Solicitante solicitante3 = new Solicitante(campos[5], campos[6], campos[7]);
                        Driver driver3 = new Driver(campos[8], campos[9], campos[10]);
                        Pedido pedido3 = new Pedido(solicitante3, driver3, eats, LocalDateTime.parse(campos[11], formatter));
                        escrita.write(pedido3.fecharPedido() + "\r\n");
                        break;
                    default:
                        System.out.println("Entrada inválida!!!");
                }
            }

            leitura.close();
            escrita.close();
            fileW.close();
        } catch (CorrespondenciaPreenchimentoIncompletoException | SolicitantePreenchimentoIncompletoException | ProdutoSemOrigemDestinoException var24) {
            var24.printStackTrace();
        } catch (PedidoSemProdutoException var25) {
            var25.printStackTrace();
        } catch (PedidoSemDriverException var26) {
            var26.printStackTrace();
        } catch (PedidoSemSolicitanteException var27) {
            var27.printStackTrace();
        } catch (EatsPreenchimentoIncompletoException var28) {
            var28.printStackTrace();
        }

    }
}
