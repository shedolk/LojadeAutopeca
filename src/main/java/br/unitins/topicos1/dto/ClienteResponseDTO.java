package br.unitins.topicos1.dto;

import br.unitins.topicos1.modelo.Cliente;

public record ClienteResponseDTO(
    long id,
    String nome,
    String email,
    String endereco
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
