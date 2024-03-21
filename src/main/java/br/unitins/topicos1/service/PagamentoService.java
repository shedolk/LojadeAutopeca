package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.PagamentoDTO;
import br.unitins.topicos1.dto.PagamentoResponseDTO;
import jakarta.validation.Valid;

public interface PagamentoService {
    public PagamentoResponseDTO insert(@Valid PagamentoDTO dto);

    PagamentoResponseDTO update(Long id, PagamentoDTO dto);

    void delete(Long id);

    public PagamentoResponseDTO findById(Long id);

    public List<PagamentoResponseDTO> findByAll();

}
