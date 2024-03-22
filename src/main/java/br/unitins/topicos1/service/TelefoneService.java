package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.TelefoneResponseDTO;

public interface TelefoneService {
    public TelefoneResponseDTO insert(TelefoneDTO dto, Long idUsuario);

    TelefoneResponseDTO update(Long id, TelefoneDTO dto, Long idUsuario);

    void delete(Long id);

    public TelefoneResponseDTO findById(Long id);

    public List<TelefoneResponseDTO> findByAll();

    public List<TelefoneResponseDTO> findByIdUser(Long idUsuario);
}
