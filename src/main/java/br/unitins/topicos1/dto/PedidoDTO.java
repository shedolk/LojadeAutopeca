package br.unitins.topicos1.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.unitins.topicos1.model.Cupom;
import br.unitins.topicos1.model.Pagamento;

public record PedidoDTO(
        LocalDateTime dataPedido,
        Pagamento pagamento,
        Integer statusPedido,
        Cupom cupom,
        Double totalPedido,
        UsuarioResponseDTO usuario,
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
