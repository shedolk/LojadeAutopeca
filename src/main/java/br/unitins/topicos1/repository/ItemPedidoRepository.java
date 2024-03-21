package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.ItemPedido;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemPedidoRepository implements PanacheRepository<ItemPedido> {

    public ItemPedido findById(Integer id) {
        if (id == null)
            return null;
        return find("id", id).firstResult();
    }

    public List<ItemPedido> findByIdUser(Long idUsuario) {
        return find("usuario.id = ?1", idUsuario).list();
    }
}
