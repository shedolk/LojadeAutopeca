package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.CupomDTO;
import br.unitins.topicos1.dto.CupomResponseDTO;
import jakarta.validation.Valid;

public interface CupomService {
    public CupomResponseDTO insert(@Valid CupomDTO dto);

    CupomResponseDTO update(Long id, @Valid CupomDTO dto);

    void delete(Long id);

    public CupomResponseDTO findById(Long id);

    public List<CupomResponseDTO> findByAll();

}
