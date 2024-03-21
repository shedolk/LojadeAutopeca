package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.ItemPedidoDTO;
import br.unitins.topicos1.service.ItemPedidoService;
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

@Path("/itempedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemPedidoResource {
    @Inject
    ItemPedidoService itempedidoService;

    @POST
    public Response insert(ItemPedidoDTO dto, Long idUsuario) {
        return Response.status(Status.CREATED).entity(itempedidoService.insert(dto, idUsuario)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, ItemPedidoDTO dto, Long idUsuario) {
        itempedidoService.update(id, dto, idUsuario);
        return Response.noContent().build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        itempedidoService.delete(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(itempedidoService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(itempedidoService.findByAll()).build();
    }

    @GET
    @Path("/usuario/{id}")
    public Response findByIdUser(@PathParam("id") Long id) {
        return Response.ok(itempedidoService.findByIdUser(id)).build();
    }
}
