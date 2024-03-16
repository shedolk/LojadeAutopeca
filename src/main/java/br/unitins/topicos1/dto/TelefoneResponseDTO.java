package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Telefone;

public record TelefoneResponseDTO(
        Long id,
        String codigoArea,
        String numero,
        UsuarioResponseDTO usuario) {
    public static TelefoneResponseDTO valueOf(Telefone telefone) {
        return new TelefoneResponseDTO(
                telefone.getId(),
                telefone.getCodigoArea(),
                telefone.getNumero(),
                UsuarioResponseDTO.valueOf(telefone.getUsuario()));
    }
}
