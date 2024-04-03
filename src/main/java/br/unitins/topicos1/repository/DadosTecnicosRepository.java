package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.DadosTecnicos;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DadosTecnicosRepository implements PanacheRepository<DadosTecnicos>{
    
    public PanacheQuery<DadosTecnicos> findByNome(String compatibilidade) {
        if (compatibilidade == null)
            return null;
        return find("UPPER(compatibilidade) LIKE ?1 ", "%" + compatibilidade.toUpperCase() + "%");
    }

    public DadosTecnicos findById(Long id){
        if (id == null)
            return null;
        return find("id", id).firstResult();
    }
}
