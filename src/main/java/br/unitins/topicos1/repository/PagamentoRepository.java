package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.Pagamento;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PagamentoRepository implements PanacheRepository<Pagamento> {

    public Pagamento findById(Integer id) {
        if (id == null)
            return null;
        return find("id", id).firstResult();
    }
}
