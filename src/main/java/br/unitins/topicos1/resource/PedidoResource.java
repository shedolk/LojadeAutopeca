package br.unitins.topicos1.resource;

import java.time.LocalDateTime;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;

import br.unitins.topicos1.application.Result;
import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.PedidoResponseDTO;
import br.unitins.topicos1.dto.ProductDTO;
import br.unitins.topicos1.dto.ProductResponseDTO;
import br.unitins.topicos1.service.PedidoService;
import br.unitins.topicos1.service.UsuarioService;
//import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
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

@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoResource {

    @Inject
    PedidoService service;

    @Inject
    UsuarioService usuarioService;

    @Inject
    JsonWebToken jwt;

    private static final Logger LOG = Logger.getLogger(PedidoResource.class);

    @POST
    // @RolesAllowed({ "User", "Admin" })
    public Response insert(PedidoDTO dto) {

        LOG.info("USUARIO REALIZANDO UM PEDIDO");

        String login = jwt.getSubject();

        PedidoResponseDTO retorno = service.insert(dto, login);

        LOG.info("data e hora do pedido: " + LocalDateTime.now());

        return Response.status(201).entity(retorno).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    // @RolesAllowed({"Admin"})
    public Response update(@PathParam("id") Long id, PedidoDTO dto) {
        try {
            PedidoResponseDTO pedido = service.update(id, dto);
            return Response.ok(pedido).build();

        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }

    }

    @GET
    @Path("/")

    public Response findAll() {
        LOG.info("BUSCANDO TODOS OS PEDIDOS FEITOS POR ESSE USUARIO");

        return Response.ok(service.findByAll()).build();
    }

    @GET
    // @RolesAllowed({ "User", "Admin" })
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }

    @DELETE
    @Transactional
    // @RolesAllowed({ "Admin" })
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}