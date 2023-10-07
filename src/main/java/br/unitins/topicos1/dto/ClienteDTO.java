package br.unitins.topicos1.dto;

import br.unitins.topicos1.modelo.Endereco;

public record  ClienteDTO (
     String nome,
     String email,
     Endereco endereco
){
    
    
}
