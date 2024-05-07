package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.EnderecoDTO;
import br.unitins.topicos1.dto.EnderecoResponseDTO;
import jakarta.validation.Valid;

public interface EnderecoService {
    public EnderecoResponseDTO insert(@Valid EnderecoDTO dto);

    EnderecoResponseDTO update(Long id, EnderecoDTO dto);

    void delete(Long id);

    public EnderecoResponseDTO findById(Long id);

    public List<EnderecoResponseDTO> findByAll();

    public List<EnderecoResponseDTO> findByIdUser(Long idUsuario);
}
