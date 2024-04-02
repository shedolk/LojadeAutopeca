package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ItemPedidoDTO;
import br.unitins.topicos1.dto.ItemPedidoResponseDTO;
import jakarta.validation.Valid;

public interface ItemPedidoService {
    public ItemPedidoResponseDTO insert(@Valid ItemPedidoDTO dto, Long idUsuario);

    public ItemPedidoResponseDTO update(Long id, @Valid ItemPedidoDTO dto, Long idUsuario);

    void delete(Long id);

    public ItemPedidoResponseDTO findById(Long id);

    public List<ItemPedidoResponseDTO> findByAll();

    // public List<ItemPedidoResponseDTO> findByIdUser(Long idUsuario);
}
