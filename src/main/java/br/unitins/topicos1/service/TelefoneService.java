package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.TelefoneResponseDTO;

public interface TelefoneService {
    public TelefoneResponseDTO insert(TelefoneDTO dto, Long idUsuario);

    TelefoneResponseDTO update(Long id, TelefoneDTO dto);

    public TelefoneResponseDTO findById(Long id);

    public List<TelefoneResponseDTO> findByAll();

    public void delete(Long id);
}
