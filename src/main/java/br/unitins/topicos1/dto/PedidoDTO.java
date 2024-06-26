package br.unitins.topicos1.dto;

import java.time.LocalDateTime;

public record PedidoDTO(
        LocalDateTime dataPedido,
        Integer pagamento_id,
        Integer statusPedido,
        Integer cupom_id,
        Double totalPedido,
        Long usuario_id

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
