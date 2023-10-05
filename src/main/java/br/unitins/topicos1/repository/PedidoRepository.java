package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.modelo.Pedido;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class PedidoRepository implements PanacheRepository<Pedido>{
    public List<Pedido> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1) ", "%"+nome+"%").list();
    }
}
