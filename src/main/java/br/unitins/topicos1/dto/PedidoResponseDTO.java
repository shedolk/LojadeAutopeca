package br.unitins.topicos1.dto;

import java.time.LocalDate;
import java.util.List;

import br.unitins.topicos1.modelo.Cliente;
import br.unitins.topicos1.modelo.Pedido;

public record PedidoResponseDTO(
                Long id,
                LocalDate date,
                List<ItemPedidoDTO> itemPedido,
                String endereco,
                Cliente cliente

) {
        public static PedidoResponseDTO valueOf(Pedido pedido) {
                return new PedidoResponseDTO(
                                pedido.getId(),
                                pedido.getDate(),
                                pedido.getItemPedido()
                                                .stream()
                                                .map(t -> ItemPedidoDTO.valueOf(t)).toList(),
                                pedido.getEndereco(),
                                pedido.getCliente()

                );
        }
}
