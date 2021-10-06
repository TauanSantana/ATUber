package br.com.ATUber.ATUber.model.service;

import br.com.ATUber.ATUber.model.auxiliar.CorridaModel;
import br.com.ATUber.ATUber.model.domain.Corrida;
import br.com.ATUber.ATUber.model.domain.Produto;
import br.com.ATUber.ATUber.model.domain.Solicitante;
import br.com.ATUber.ATUber.model.repository.CorridaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorridaService {
    @Autowired
    private CorridaRepository corridaRepository;
    public List<Corrida> obterCorridas(Integer solicitanteId){
        return corridaRepository.obterLista(solicitanteId);
    }
    public void Incluir(CorridaModel model, Solicitante solicitante)
    {
        var corrida = new Corrida(model.getOrigem(),model.getDestino());
        corrida.setComAnimais(model.ComAnimais());
        corrida.setParadaNoCaminho(model.ParadaNoCaminho());
        corrida.solicitante = solicitante;
        corridaRepository.save(corrida);
    }
    public void Excluir(Integer id)
    {
        corridaRepository.deleteById(id);
    }
}
