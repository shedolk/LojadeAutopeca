package br.unitins.topicos1.dto;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoDTO(

    // Pagamento pagamento,
    // EnderecoDTO endereco,
    List<ItemPedidoDTO> itens,
    LocalDateTime dataHora,
    Integer idPagamento
) {
    
}
