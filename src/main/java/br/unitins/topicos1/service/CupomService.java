package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.CupomDTO;
import br.unitins.topicos1.dto.CupomResponseDTO;

public interface CupomService {
    
    public CupomResponseDTO insert(CupomDTO dto);

    public CupomResponseDTO update(CupomDTO dto, Long id);

    public void delete(Long id);

    public CupomResponseDTO findById(Long id);

    public List<CupomResponseDTO> findByNome(String nome);

    public List<CupomResponseDTO> findByAll(); 
}
