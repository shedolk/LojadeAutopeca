package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.service.PedidoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class PedidoResource {
    @Inject
    PedidoService service;

     @POST
    public ResponseBuilder insert(PedidoDTO dto) {
        Response.status(Status.CREATED).entity(service.insert(dto));
        return  Response.status(Status.CREATED).entity(service.insert(dto));
    }
}
