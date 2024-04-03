package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.DadosTecnicosDTO;
import br.unitins.topicos1.dto.DadosTecnicosResponseDTO;
import jakarta.validation.Valid;

public interface DadosTecnicosService {

    DadosTecnicosResponseDTO findById(Long id);
    
    DadosTecnicosResponseDTO create(@Valid DadosTecnicosDTO dto);
    
    DadosTecnicosResponseDTO update(Long id, DadosTecnicosDTO dto);
    
    void delete(Long id);

    public List<DadosTecnicosResponseDTO> findByAll();
}
