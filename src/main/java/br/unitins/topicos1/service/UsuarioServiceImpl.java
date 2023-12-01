package br.unitins.topicos1.service;

import java.util.ArrayList;
import java.util.List;

import br.unitins.topicos1.dto.EnderecoDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.UsuarioDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.model.Endereco;
import br.unitins.topicos1.model.Perfil;
import br.unitins.topicos1.model.Telefone;
import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import br.unitins.topicos1.validation.ValidationException;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    UsuarioRepository repository;

    @Inject
    HashService hashService;

    @Override
    @Transactional
    public UsuarioResponseDTO insert(@Valid UsuarioDTO dto) {

        if (repository.findByLogin(dto.login()) != null) {
            throw new ValidationException("login", "Login já existe.");
        }

        try {

            Usuario novoUsuario = new Usuario();
            novoUsuario.setNome(dto.nome());
            novoUsuario.setLogin(dto.login());

            novoUsuario.setSenha(hashService.getHashSenha(dto.senha()));
            novoUsuario.setCpf(dto.cpf());
            novoUsuario.setPerfil(Perfil.valueOf(dto.idPerfil()));

            if (dto.listaTelefone() != null &&
                    !dto.listaTelefone().isEmpty()) {
                novoUsuario.setListaTelefone(new ArrayList<Telefone>());
                for (TelefoneDTO tel : dto.listaTelefone()) {
                    Telefone telefone = new Telefone();
                    telefone.setCodigoArea(tel.codigoArea());
                    telefone.setNumero(tel.numero());
                    novoUsuario.getListaTelefone().add(telefone);
                }
            }

            if (dto.listaEndereco() != null && !dto.listaTelefone().isEmpty()) {
                novoUsuario.setListaEndereco(new ArrayList<Endereco>());
                for (EnderecoDTO end : dto.listaEndereco()) {
                    Endereco endereco = new Endereco();
                    endereco.setRua(end.rua());
                    endereco.setNumero(end.numero());
                    endereco.setCidade(end.cidade());
                    endereco.setEstado(end.estado());
                    endereco.setCep(end.cep());
                    novoUsuario.getListaEndereco().add(endereco);
                }
            }

            repository.persist(novoUsuario);

            return UsuarioResponseDTO.valueOf(novoUsuario);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir usuário", e);
        }

    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(UsuarioDTO dto, Long id) {
        Usuario usuario = repository.findById(id);

        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }
        try {

            usuario.setNome(dto.nome());
            usuario.setLogin(dto.login());
            usuario.setSenha(dto.senha());
            usuario.setCpf(dto.cpf());

            List<Telefone> telefones = new ArrayList<>();
            for (TelefoneDTO tel : dto.listaTelefone()) {
                Telefone telefone = new Telefone();
                telefone.setCodigoArea(tel.codigoArea());
                telefone.setNumero(tel.numero());
                telefones.add(telefone);
            }
            List<Endereco> enderecos = new ArrayList<>();
            for (EnderecoDTO end : dto.listaEndereco()) {
                Endereco endereco = new Endereco();
                endereco.setRua(end.rua());
                endereco.setNumero(end.numero());
                endereco.setCidade(end.cidade());
                endereco.setEstado(end.estado());
                endereco.setCep(end.cep());
                enderecos.add(endereco);
            }

            return UsuarioResponseDTO.valueOf(usuario);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar usuário", e);
        }
    }

    @Override
    public UsuarioResponseDTO updateNomeImagem(Long id, String nomeImagem) {
        Usuario usuario = repository.findById(id);
        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        try {
            if (!repository.deleteById(id)) {
                throw new NotFoundException("Usuário não encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir usuário", e);
        }
    }

    @Override
    public UsuarioResponseDTO findById(Long id) {
        return UsuarioResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<UsuarioResponseDTO> findByNome(String nome) {
        return null;
    }

    @Override
    public List<UsuarioResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> UsuarioResponseDTO.valueOf(e)).toList();
    }

    @Override
    public UsuarioResponseDTO findByLoginAndSenha(String login, String senha) {
        Usuario usuario = repository.findByLoginAndSenha(login, senha);
        if (usuario == null)
            throw new ValidationException("login", "Login ou senha inválido");

        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    public UsuarioResponseDTO findByLogin(String login) {
        Usuario usuario = repository.findByLogin(login);
        if (usuario == null)
            throw new ValidationException("login", "Login inválido");

        return UsuarioResponseDTO.valueOf(usuario);
    }

    @PATCH
    @Path("/{id}/updateNome/{newNome}")
    @Transactional
    public Response updateNome(@PathParam("id") Long id, @PathParam("newNome") String newNome) {
        Usuario usuario = repository.findById(id);

        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }

        try {
            usuario.setNome(newNome);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar nome do usuário", e);
        }
    }

    @PATCH
    @Path("/{id}/updateSenha/{newSenha}")
    @Transactional
    public Response updateSenha(@PathParam("id") Long id, @PathParam("newSenha") String newSenha) {
        Usuario usuario = repository.findById(id);

        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }

        try {
            usuario.setSenha(hashService.getHashSenha(newSenha));
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar senha do usuário", e);
        }
    }

    @PATCH
    @Path("/{id}/updateLogin/{novoLogin}")
    @Transactional
    public Response updateLogin(@PathParam("id") Long id, @PathParam("novoLogin") String newLogin) {
        Usuario usuario = repository.findById(id);

        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }

        try {

            if (repository.findByLogin(newLogin) != null) {
                throw new ValidationException("login", "Login já existe.");
            }

            usuario.setLogin(newLogin);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar login do usuário", e);
        }
    }

    @PATCH
    @Path("/{id}/updateTelefones")
    @Transactional
    public Response updateTelefones(@PathParam("id") Long id, List<TelefoneDTO> newTelefones) {
        Usuario usuario = repository.findById(id);

        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }

        try {
            usuario.getListaTelefone().clear();

            if (newTelefones != null && !newTelefones.isEmpty()) {
                for (TelefoneDTO tel : newTelefones) {
                    Telefone telefone = new Telefone();
                    telefone.setCodigoArea(tel.codigoArea());
                    telefone.setNumero(tel.numero());
                    usuario.getListaTelefone().add(telefone);
                }
            }

            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar telefones do usuário", e);
        }
    }

}
