package br.unitins.topicos1.dto;

import java.util.List;

//import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO (

    @NotBlank(message = "O nome deve ser informado")
    String nome,

    @NotBlank(message = "O campo nome não pode ser nulo.")
    String login,

    @NotBlank(message = "O campo nome não pode ser nulo.")
    String senha,

    @NotBlank(message = "O campo nome não pode ser nulo.")
    String cpf,

    Integer idPerfil,
    List<TelefoneDTO> listaTelefone,
    List<EnderecoDTO> listaEndereco
    
){

}
