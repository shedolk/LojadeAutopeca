package br.unitins.topicos1.dto;

import java.time.LocalDate;
import java.util.List;

import br.unitins.topicos1.modelo.Cliente;
import br.unitins.topicos1.modelo.Endereco;
import jakarta.validation.constraints.NotBlank;


public class  PedidoDTO {
      @NotBlank(message = "O campo date não pode ser nulo.")
     private final LocalDate date;
     private final List<ItemPedidoDTO> listaItemPedido;
     @NotBlank(message = "O campo endereco não pode ser nulo.")
     private final Endereco endereco;
     @NotBlank(message = "O campo cliente não pode ser nulo.")
     private final Cliente cliente;
     
    
     public PedidoDTO(@NotBlank(message = "O campo date não pode ser nulo.") LocalDate date,
               List<ItemPedidoDTO> listaItemPedido,
               @NotBlank(message = "O campo endereco não pode ser nulo.") Endereco endereco,
               @NotBlank(message = "O campo cliente não pode ser nulo.") Cliente cliente) {
          this.date = date;
          this.listaItemPedido = listaItemPedido;
          this.endereco = endereco;
          this.cliente = cliente;
     }
     public LocalDate getDate() {
          return date;
     }
     public List<ItemPedidoDTO> getListaItemPedido() {
          return listaItemPedido;
     }
     public Endereco getEndereco() {
          return endereco;
     }
     public Cliente getCliente() {
          return cliente;
     }
     @Override
     public int hashCode() {
          final int prime = 31;
          int result = 1;
          result = prime * result + ((date == null) ? 0 : date.hashCode());
          result = prime * result + ((listaItemPedido == null) ? 0 : listaItemPedido.hashCode());
          result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
          result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
          return result;
     }
     @Override
     public boolean equals(Object obj) {
          if (this == obj)
               return true;
          if (obj == null)
               return false;
          if (getClass() != obj.getClass())
               return false;
          PedidoDTO other = (PedidoDTO) obj;
          if (date == null) {
               if (other.date != null)
                    return false;
          } else if (!date.equals(other.date))
               return false;
          if (listaItemPedido == null) {
               if (other.listaItemPedido != null)
                    return false;
          } else if (!listaItemPedido.equals(other.listaItemPedido))
               return false;
          if (endereco == null) {
               if (other.endereco != null)
                    return false;
          } else if (!endereco.equals(other.endereco))
               return false;
          if (cliente == null) {
               if (other.cliente != null)
                    return false;
          } else if (!cliente.equals(other.cliente))
               return false;
          return true;
     }
}
