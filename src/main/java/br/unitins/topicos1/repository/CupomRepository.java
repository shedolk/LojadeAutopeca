package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Cupom;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class CupomRepository implements PanacheRepository<Cupom>{
    public List<Cupom> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1) ", "%"+nome+"%").list();
    }
}
