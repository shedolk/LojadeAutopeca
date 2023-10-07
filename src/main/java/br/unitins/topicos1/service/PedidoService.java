package br.unitins.topicos1.service;

import java.util.List;
import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.PedidoResponseDTO;

public interface PedidoService {
      public PedidoResponseDTO insert(PedidoDTO dto);

    public PedidoResponseDTO update(PedidoDTO dto, Long id);

    public void delete(Long id);

    public PedidoResponseDTO findById(Long id);

    public List<PedidoResponseDTO> findByCodigo(String codigo);

    public List<PedidoResponseDTO> findByAll(); 
}

