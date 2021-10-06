package br.com.ATUber.ATUber.model.repository;

import br.com.ATUber.ATUber.model.domain.Corrida;
import br.com.ATUber.ATUber.model.domain.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorridaRepository extends CrudRepository<Corrida, Integer> {
    @Query("from Corrida p where p.solicitante.id = :solicitanteId")
    public List<Corrida> obterLista(Integer solicitanteId);
}
