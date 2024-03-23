package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Pedido;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PedidoRepository implements PanacheRepository<Pedido> {

    public List<Pedido> findAll(String login) {
        return find("pedido.login = ?1", login).list();
    }

    public List<Pedido> findAll(Long idPedido) {
        return find("pedido.id = ?1", idPedido).list();
    }

    public Pedido findByLoginAndSenha(String login, String senha) {
        try {
            return find("login = ?1 AND senha = ?2 ", login, senha).singleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Transactional
    public Pedido findByIdUser1(Long idUsuario) {
        TypedQuery<Pedido> query = getEntityManager()
                .createQuery("SELECT p FROM Pedido p WHERE p.usuario.id = :idUsuario", Pedido.class);
        query.setParameter("idUsuario", idUsuario);
        return query.getSingleResult();
    }

    @Transactional
    public List<Pedido> findByIdUser(Long idUsuario) {
        TypedQuery<Pedido> query = getEntityManager()
                .createQuery("SELECT p FROM Pedido p WHERE p.usuario.id = :idUsuario", Pedido.class);
        query.setParameter("idUsuario", idUsuario);
        return query.getResultList();
    }

}