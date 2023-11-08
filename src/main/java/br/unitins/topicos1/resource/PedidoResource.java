package br.unitins.topicos1.resource;

import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.PedidoResponseDTO;
import br.unitins.topicos1.service.ClienteService;
import br.unitins.topicos1.service.PedidoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/pedido")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoResource {

    @Inject
    PedidoService service;

    @Inject
    ClienteService clienteService;

    @Inject
    JsonWebToken jwt;

    @POST
    @RolesAllowed({"User", "Admin"})
    public Response insert(PedidoDTO dto) {

        String login = jwt.getSubject();

        PedidoResponseDTO retorno = service.insert(dto, login);
        return Response.status(201).entity(retorno).build();
    }

    @GET
    public Response findAll() {

        return Response.ok(service.findByAll()).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    @RolesAllowed({"User", "Admin"})
    public Response update(PedidoDTO dto, @PathParam("id") Long id) {
         String login = jwt.getSubject();
        service.update(dto, id , login);
        return Response.noContent().build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }

    @GET
    @Path("/search/codigo/{codigo}")
    public Response findByCodigo(@PathParam("codigo") String codigo) {
        return Response.ok(service.findByCodigo(codigo)).build();
    }

}
