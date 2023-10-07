package br.unitins.topicos1.dto;

import java.util.List;

import br.unitins.topicos1.modelo.Cliente;

public record ClienteResponseDTO(
        Long id,
        String nome,
        String email,
        List<EnderecoDTO> endereco) 
        {
             public static ClienteResponseDTO valueOf(Cliente cliente){

        return new ClienteResponseDTO(
            cliente.getId(),
           cliente.getNome(),
            cliente.getEmail(),
           cliente.getEndereco()
            .stream().
            map(t -> EnderecoDTO.valueOf(t)).toList()
        );
    }

}
