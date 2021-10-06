package br.com.ATUber.ATUber.model.service;

import br.com.ATUber.ATUber.model.domain.Corrida;
import br.com.ATUber.ATUber.model.domain.Solicitante;
import br.com.ATUber.ATUber.model.repository.CorridaRepository;
import br.com.ATUber.ATUber.model.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;
    public Solicitante autenticar(String email, String senha){
        return (Solicitante) loginRepository.autenticacao(email, senha);
    }
    public Solicitante CadastrarSolicitante(String email, String senha, String cpf, String nome){
        Solicitante solicitante = new Solicitante();
        solicitante.setEmail(email);
        solicitante.setSenha(senha);
        solicitante.setCpf(cpf);
        solicitante.setNome(nome);
        loginRepository.save(solicitante);

        return solicitante;
    }
}
