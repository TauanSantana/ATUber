package br.com.ATUber.ATUber.model.repository;

import br.com.ATUber.ATUber.model.domain.Corrida;
import br.com.ATUber.ATUber.model.domain.Solicitante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<Solicitante, Integer> {
    @Query("from Solicitante s where s.email = :email and s.senha = :senha")
    public Solicitante autenticacao(String email, String senha);
}
