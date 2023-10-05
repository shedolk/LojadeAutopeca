package br.unitins.topicos1.dto;

import br.unitins.topicos1.modelo.Cliente;

public record ClienteResponseDTO(
    String nome,
    String email,
    String endereco
) {
    public static ClienteDTO  valueOf(Cliente cliente){
        return new ClienteDTO(
            cliente.getNome(),
             cliente.getEmail(),
              cliente.getEndereco()
        );
    }
}
