package br.unitins.topicos1.dto;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoDTO(
        LocalDateTime dataPedido,
        Integer pagamento_id,
        Integer statusPedido,
        Integer cupom_id,
        Double totalPedido,
        Integer usuario_id,
        List<ItemPedidoDTO> itens

) {
    // public static PedidoDTO valueOf(Pedido pedido) {
    // return new PedidoDTO(
    // pedido.getDataPedido(),
    // pedido.getPagamento(),
    // pedido.getStatusPedido(),
    // pedido.getCupom(),
    // pedido.getTotalPedido(),
    // UsuarioResponseDTO.valueOf(pedido.getUsuario()),
    // pedido.getItens()
    // .stream()
    // .map(t -> ItemPedidoDTO.valueOf(t)).toList());
    // }

}
