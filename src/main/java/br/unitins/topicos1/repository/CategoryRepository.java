package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.Category;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoryRepository implements PanacheRepository<Category> {

    public PanacheQuery<Category> findByNome(String category) {
        if (category == null)
            return null;
        return find("UPPER(category) LIKE ?1 ", "%" + category.toUpperCase() + "%");
    }

    public Category findById(Long id) {
        if (id == null)
            return null;
        return find("id", id).firstResult();
    }
}
