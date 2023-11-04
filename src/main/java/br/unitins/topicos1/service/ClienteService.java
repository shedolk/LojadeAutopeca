package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.ClienteResponseDTO;
import br.unitins.topicos1.dto.PatchSenhaDTO;
import jakarta.validation.Valid;

public interface ClienteService {
    public ClienteResponseDTO insert(@Valid ClienteDTO dto);

    public ClienteResponseDTO update(ClienteDTO dto, Long id);

    public void delete(Long id);

    public ClienteResponseDTO findById(Long id);

    public List<ClienteResponseDTO> findByNome(String nome);

    public ClienteResponseDTO findByLoginAndSenha(String login, String senha);

    public ClienteResponseDTO findByLogin(String login);

     public String updateSenha(PatchSenhaDTO senha, Long id);

    public List<ClienteResponseDTO> findByAll(); 
}
