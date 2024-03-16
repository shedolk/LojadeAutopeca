package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Telefone;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TelefoneRepository implements PanacheRepository<Telefone> {

    public PanacheQuery<Telefone> findByNome(String telefone) {
        if (telefone == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%" + telefone.toUpperCase() + "%");
    }

    public List<Telefone> findAll(Long idUsuario) {
        return find("usuario.id = ?1", idUsuario).list();
    }
}
