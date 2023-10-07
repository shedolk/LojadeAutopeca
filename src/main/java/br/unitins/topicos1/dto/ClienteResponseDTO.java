package br.unitins.topicos1.dto;

import br.unitins.topicos1.modelo.Cliente;
import br.unitins.topicos1.modelo.Endereco;

public record ClienteResponseDTO(
    Long id,
    String nome,
    String email,
    Endereco endereco
) {
    public static ClienteResponseDTO  valueOf(Cliente cliente){
        return new ClienteResponseDTO(
            cliente.getId(),
            cliente.getNome(),
             cliente.getEmail(),
              cliente.getEndereco()
        );
    }
}
