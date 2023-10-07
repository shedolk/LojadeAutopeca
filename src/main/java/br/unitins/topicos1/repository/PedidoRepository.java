package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.modelo.Pedido;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PedidoRepository implements PanacheRepository<Pedido> {
    public List<Pedido> findByCodigo(String codigo) {
        return find("UPPER(codigo) LIKE UPPER(?1) ", "%" + codigo + "%").list();
    }

}
