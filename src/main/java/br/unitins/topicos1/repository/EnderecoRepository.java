package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Endereco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco> {

    public List<Endereco> findByIdUser(Long idUsuario) {
        return find("usuario.id = ?1", idUsuario).list();
    }

    @Transactional
    public void deleteByUsuarioId(Long usuarioId) {
        delete("usuario.id", usuarioId);
    }

    public Endereco findById(Integer id) {
        if (id == null)
            return null;
        return find("id", id).firstResult();
    }

}
