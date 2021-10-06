package br.com.ATUber.ATUber.model.service;

import br.com.ATUber.ATUber.model.domain.Endereco;
import com.google.gson.Gson;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

@Service
public class EnderecoService {

    public Endereco obterCep(String cep) {

        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("https://viacep.com.br/ws/" + cep + "/json");
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        response.close();
        Endereco data = new Gson().fromJson(value, Endereco.class);
        return data;
    }
}
