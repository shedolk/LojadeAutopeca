package br.unitins.topicos1.dto;

import java.util.List;

public record ClienteDTO(
      String nome,
      String login,
      String senha,
      Integer idPerfil,
      String email,
      List<EnderecoDTO> listaEndereco
) { 
    
}

