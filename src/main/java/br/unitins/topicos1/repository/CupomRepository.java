package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.Cupom;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CupomRepository implements PanacheRepository<Cupom> {

    public Cupom findById(Integer id) {
        if (id == null)
            return null;
        return find("id", id).firstResult();
    }
}
