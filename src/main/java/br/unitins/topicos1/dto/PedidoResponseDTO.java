package br.unitins.topicos1.dto;

import java.time.LocalDate;
import java.util.List;
import br.unitins.topicos1.modelo.Pedido;


public record PedidoResponseDTO(
    Long id,
    String codigo,
    LocalDate date,
    List<ItemPedidoDTO> itemPedido,
    List<EnderecoDTO> Endereco,
    List<ClienteResponseDTO> cliente
) {
    public static PedidoResponseDTO valueOf(Pedido pedido) {
        return new PedidoResponseDTO(
            pedido.getId(),
            pedido.getCodigo(),
            pedido.getDate(),
            pedido.getItemPedido()
                .stream()
                .map(ItemPedidoDTO::valueOf)
                .toList(),
            pedido.getEndereco()
                .stream()
                .map(EnderecoDTO::valueOf)
                .toList(),
            pedido.getCliente()
                .stream()
                .map(ClienteResponseDTO::valueOf)
                .toList()
        );
    }
}

