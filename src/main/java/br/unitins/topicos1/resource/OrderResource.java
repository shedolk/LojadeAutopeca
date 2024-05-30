package br.unitins.topicos1.resource;

import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.topicos1.dto.OrderDTO;
import br.unitins.topicos1.dto.OrderResponseDTO;
import br.unitins.topicos1.service.OrderService;
import br.unitins.topicos1.service.UsuarioService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {
    
    @Inject
    OrderService service;

    @Inject
    UsuarioService usuarioService;

    @Inject
    JsonWebToken jwt;

    @POST
    @RolesAllowed({"User", "Admin"})
    @Transactional
    public Response insert(OrderDTO dto) {

        String login = jwt.getSubject();
        
        OrderResponseDTO retorno = service.insert(dto, login);
        return Response.status(201).entity(retorno).build();
    }

    @GET
    @RolesAllowed({"User", "Admin"})
    public Response findAll() {
        
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @RolesAllowed({"User", "Admin"})
    @Path("/user/{login}")
    public Response findByUser(@PathParam("login") String login) {
        return Response.ok(service.findByAll(login)).build();
    }

    @GET
    @RolesAllowed({"User", "Admin"})
    public Response findAll(@QueryParam("login") String login) {
        if (login != null && !login.isEmpty()) {
            return Response.ok(service.findByAll(login)).build();
        }
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @RolesAllowed({"User", "Admin"})
    public Response findById(Long id) {
        
        return Response.ok(service.findById(id)).build();
    }
}
