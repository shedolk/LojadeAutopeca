package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.Endereco;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco> {
    
      public PanacheQuery<Endereco> findByNome(String endereco) {
        if (endereco == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%" + endereco.toUpperCase() + "%");
    }
}
