package br.unitins.topicos1.resource;

import br.unitins.topicos1.repository.StatusPedidoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/statuspedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StatusPedidoResource {

    @Inject
    StatusPedidoRepository statuspedidoService;

    @GET
    public Response findAll() {
        return Response.ok(statuspedidoService.findAll()).build();
    }
}
