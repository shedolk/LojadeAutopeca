package br.unitins.topicos1.resource;


import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.topicos1.dto.PatchSenhaDTO;
import br.unitins.topicos1.service.UsuarioService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/usuariologado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioLogadoResource {
    
    @Inject
    JsonWebToken jwt;

    @Inject
    UsuarioService usuarioService;

    @GET
    @RolesAllowed({ "User", "Admin" })
    public Response getUsuario() {

        // obtendo o login pelo token jwt
        String login = jwt.getSubject();

        return Response.ok(usuarioService.findByLogin(login)).build();

    }

    @PATCH
    @Transactional
    @RolesAllowed({"User", "Admin"})
    @Path("patch/senha/")
    public Response updatePassword(@Valid PatchSenhaDTO senha, Long idUsuario) {

    // obtendo o login pelo token jwt
    String login = jwt.getSubject();

    Long id = usuarioService.findByLogin(login).id();

    return Response.status(200).entity(usuarioService.updatePassword(senha, id)).build();
  }

}
