package br.com.ATUber.ATUber.model.auxiliar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import org.springframework.core.io.ClassPathResource;

public class Helpers {
    public Helpers() {
    }

    public static float gerarValorAleatorioProduto() {
        float leftLimit = 25.0F;
        float rightLimit = 50.0F;
        return leftLimit + (new Random()).nextFloat() * (rightLimit - leftLimit);
    }

    public static float gerarValorAleatorioProduto(float left, float right) {
        return left + (new Random()).nextFloat() * (right - left);
    }

    public void writeFile(String caminho, String nomeArquivo, String conteudo) throws IOException {
        FileWriter fileWriter = new FileWriter(caminho + nomeArquivo);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(conteudo + "\r\n");
        bufferedWriter.close();
        fileWriter.close();
    }

    public ArrayList<String> readFile(String caminho, String nomeArquivo) throws IOException {
        InputStream resource = (new ClassPathResource(caminho + nomeArquivo)).getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource));
        ArrayList tmp = new ArrayList();

        String st;
        while((st = bufferedReader.readLine()) != null) {
            tmp.add(st);
        }

        bufferedReader.close();
        return tmp;
    }
}
