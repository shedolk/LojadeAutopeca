package br.unitins.topicos1.dto;

import java.time.LocalDate;
import java.util.List;

public record PedidoDTO(
        String codigo,
        LocalDate date,
        List<ItemPedidoDTO> itemPedido,
        List<EnderecoDTO> Endereco,
        List<ClienteDTO> cliente
    ){
}
