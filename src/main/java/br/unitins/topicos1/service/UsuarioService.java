package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.PatchNomeDTO;
import br.unitins.topicos1.dto.PatchSenhaDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.UsuarioDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.Response;


public interface UsuarioService {

    public UsuarioResponseDTO insert(@Valid UsuarioDTO dto);

    public UsuarioResponseDTO update(UsuarioDTO dto, Long id);

    public UsuarioResponseDTO updateNomeImagem(Long id, String nomeImagem) ;

    public void delete(Long id);

    public UsuarioResponseDTO findById(Long id);

    public List<UsuarioResponseDTO> findByNome(String nome);

    public UsuarioResponseDTO findByLoginAndSenha(String login, String senha);

    public UsuarioResponseDTO findByLogin(String login);

    public List<UsuarioResponseDTO> findByAll();

    Response updateNome(Long id, String newNome);

    Response updateSenha(Long id, String newSenha);

    Response updateLogin(Long id, String newLogin);

    Response updateTelefones(Long id, List<TelefoneDTO> newTelefones);

    public Object updatePassword(@Valid PatchSenhaDTO senha, Long id);

    public Object updateNomeAuth(@Valid PatchNomeDTO nome, Long id);
}
