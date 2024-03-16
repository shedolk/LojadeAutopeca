package br.unitins.topicos1.dto;

import java.util.List;

import br.unitins.topicos1.model.Perfil;
import br.unitins.topicos1.model.Usuario;

public record UsuarioResponseDTO(

                Long id,
                String nome,
                String login,
                String senha,
                String cpf,
                Perfil perfil,
                List<TelefoneDTO> listaTelefone

) {
        public static UsuarioResponseDTO valueOf(Usuario usuario) {

                if (usuario == null) {
                        return null;
                }

                return new UsuarioResponseDTO(
                                usuario.getId(),
                                usuario.getNome(),
                                usuario.getLogin(),
                                usuario.getSenha(),
                                usuario.getCpf(),
                                usuario.getPerfil(),
                                usuario.getListaTelefone()
                                                .stream()
                                                .map(t -> TelefoneDTO.valueOf(t)).toList());
        }
}
