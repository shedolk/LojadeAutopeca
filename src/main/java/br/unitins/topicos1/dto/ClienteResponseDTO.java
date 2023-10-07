package br.unitins.topicos1.dto;

import java.util.List;

import br.unitins.topicos1.modelo.Cliente;

public record ClienteResponseDTO(
        Long id,
        String nome,
        String email,
        List<EnderecoDTO> listaEndereco) 
        {
             public static ClienteResponseDTO valueOf(Cliente cliente){

        return new ClienteResponseDTO(
            cliente.getId(),
           cliente.getNome(),
            cliente.getEmail(),
           cliente.getListaEndereco()
            .stream().
            map(t -> EnderecoDTO.valueOf(t)).toList()
        );
    }

}
