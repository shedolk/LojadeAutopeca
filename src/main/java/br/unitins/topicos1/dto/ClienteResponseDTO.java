package br.unitins.topicos1.dto;

import java.util.List;

import br.unitins.topicos1.modelo.Cliente;
import br.unitins.topicos1.modelo.Perfil;

public record ClienteResponseDTO(
        Long id,
        String nome,
         String login,
        Perfil perfil,
        String email,
        List<EnderecoDTO> listaEndereco) 
        {
             public static ClienteResponseDTO valueOf(Cliente cliente){

        return new ClienteResponseDTO(
            cliente.getId(),
           cliente.getNome(),
           cliente.getLogin(),
           cliente.getPerfil(),
            cliente.getEmail(),
           cliente.getListaEndereco()
            .stream().
            map(t -> EnderecoDTO.valueOf(t)).toList()
        );
    }

}
