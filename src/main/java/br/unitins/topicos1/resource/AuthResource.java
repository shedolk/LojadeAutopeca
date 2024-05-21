package br.unitins.topicos1.resource;

//import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.LoginDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.service.HashService;
import br.unitins.topicos1.service.JwtService;
import br.unitins.topicos1.service.UsuarioService;
import jakarta.inject.Inject;
//import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/auth-usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    UsuarioService service;

    @Inject
    HashService hashService;

    @Inject
    JwtService jwtService;

    // private static final Logger LOG = Logger.getLogger(AuthResource.class);

    // @POST
    // public Response login(@Valid LoginDTO dto) {
    // LOG.infof("Iniciando a autenticacao do %s", dto.login());

    // String hashSenha = hashService.getHashSenha(dto.senha());

    // LOG.info("Hash da senha gerado.");

    // LOG.debug(hashSenha);

    // UsuarioResponseDTO result = service.findByLoginAndSenha(dto.login(),
    // hashSenha);

    // if (result != null)
    // LOG.info("Login e senha corretos.");
    // else
    // LOG.info("Login e senha incorretos.");

    // String token = jwtService.generateJwt(result);

    // LOG.info("Finalizando o processo de login.");

    // return Response.ok().header("Authorization", token).build();

    // }

    // @POST
    // public Response login(LoginDTO authDTO) {
    // String hash = hashService.getHashSenha(authDTO.senha());

    // UsuarioResponseDTO usuario = service.findByLoginAndSenha(authDTO.login(),
    // hash);

    // if (usuario.perfil().getId() == 1){
    // usuario = service.findByLoginAndSenha(authDTO.login(), hash);
    // return Response.ok(usuario)
    // .header("Authorization", jwtService.generateJwt(usuario))
    // .build();
    // }
    // else if (usuario.perfil().getId() == 2) {
    // return Response.ok(usuario)
    // .header("Authorization", jwtService.generateJwt(usuario))
    // .build();
    // // busca de usuario psicologo
    // } else {
    // return Response.status(Status.NOT_FOUND)
    // .entity("Username ou senha inválido").build();
    // }

    @POST
    public Response login(LoginDTO authDTO) {

        String hash = hashService.getHashSenha(authDTO.senha());
        
        UsuarioResponseDTO usuario = service.findByLoginAndSenha(authDTO.login(), hash);

        if (usuario != null) {
            return Response.ok(usuario)
                    .header("Authorization", jwtService.generateJwt(usuario))
                    .build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("Username ou senha inválido")
                    .build();
        }
    }
}
