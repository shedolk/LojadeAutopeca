package br.unitins.topicos1.dto;

import java.time.LocalDate;
import java.util.List;

import br.unitins.topicos1.modelo.Cliente;


public record  PedidoDTO(
     LocalDate date,
     List<ItemPedidoDTO> listaItemPedido,
     String endereco,
     Cliente cliente
) {
    
}
