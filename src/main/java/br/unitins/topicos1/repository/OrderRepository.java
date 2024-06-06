package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Order;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderRepository implements PanacheRepository<Order>{
    
    public List<Order> findAll(String login) {
        return find("usuario.login = ?1", login).list();
    }
    
    public List<Order> findAll(Long idUsuario) {
        return find("usuario.id = ?1", idUsuario).list();
    }

    public Order findByIdWithItems(Long id) {
        return find("select o from Order o join fetch o.itens i join fetch i.product p join fetch p.category where o.id = ?1", id).firstResult();
    }
}
