package br.unitins.topicos1.dto;

import br.unitins.topicos1.modelo.Endereco;

public record EnderecoDTO(
        Long id,
        String rua,
        Integer numero,
        String cidade,
        String estado,
        String cep

) {
    public static EnderecoDTO valueOf(Endereco endereco) {
        return new EnderecoDTO(
                endereco.getId(),
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getCep());
    }
}