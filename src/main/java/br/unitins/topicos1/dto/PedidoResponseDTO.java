package br.unitins.topicos1.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.unitins.topicos1.model.Pagamento;
import br.unitins.topicos1.model.Pedido;
import br.unitins.topicos1.model.StatusPedido;
import br.unitins.topicos1.model.Cupom;

public record PedidoResponseDTO(

                Long id,
                LocalDateTime dataPedido,
                Pagamento pagamento,
                StatusPedido statusPedido,
                Cupom cupom,
                Double totalPedido,
                UsuarioResponseDTO usuario,
                List<ItemPedidoDTO> itens

) {
        public static PedidoResponseDTO valueOf(Pedido pedido) {
                return new PedidoResponseDTO(
                                pedido.getId(),
                                pedido.getDataPedido(),
                                pedido.getPagamento(),
                                pedido.getStatusPedido(),
                                pedido.getCupom(),
                                pedido.getTotalPedido(),
                                UsuarioResponseDTO.valueOf(pedido.getUsuario()),
                                pedido.getItens()
                                                .stream()
                                                .map(t -> ItemPedidoDTO.valueOf(t)).toList());

        }
}
