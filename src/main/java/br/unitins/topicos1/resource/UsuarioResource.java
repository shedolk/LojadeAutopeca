package br.unitins.topicos1.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.UsuarioDTO;
import br.unitins.topicos1.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService service;

    private static final Logger LOG = Logger.getLogger(UsuarioResource.class);

    @POST
    public Response insert(UsuarioDTO dto) {
        LOG.info("Inserindo um usuario: ");

        return Response.status(Status.CREATED).entity(service.insert(dto)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(UsuarioDTO dto, @PathParam("id") Long id) {
        LOG.info("Atualizando os dados de um usuario: ");
        service.update(dto, id);
        return Response.noContent().build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }

    @GET
    public Response findAll() {
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(service.findByNome(nome)).build();
    }

    @PATCH
    @Path("/{id}/updateNome/{newNome}")
    @Transactional
    public Response updateNome(@PathParam("id") Long id, @PathParam("newNome") String newNome) {
        service.updateNome(id, newNome);
        return Response.noContent().build();
    }

    @PATCH
    @Path("/{id}/updateSenha/{newSenha}")
    @Transactional
    public Response updateSenha(@PathParam("id") Long id, @PathParam("newSenha") String newSenha) {
        service.updateSenha(id, newSenha);
        return Response.noContent().build();
    }

    @PATCH
    @Path("/{id}/updateLogin/{newLogin}")
    public Response updateLogin(@PathParam("id") Long id, @PathParam("newLogin") String newLogin) {
        try {
            service.updateLogin(id, newLogin);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PATCH
    @Path("/{id}/updateTelefones")
    public Response updateTelefones(@PathParam("id") Long id, List<TelefoneDTO> newTelefones) {
        try {
            service.updateTelefones(id, newTelefones);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}