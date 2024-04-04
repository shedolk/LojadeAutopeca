package br.unitins.topicos1.resource;

//import org.jboss.logging.Logger;



//import br.unitins.topicos1.application.Result;
import br.unitins.topicos1.dto.DadosTecnicosDTO;
import br.unitins.topicos1.dto.DadosTecnicosResponseDTO;
import br.unitins.topicos1.service.DadosTecnicosService;
import jakarta.inject.Inject;
//import jakarta.validation.ConstraintViolationException;
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

@Path("/dadostecnicos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DadosTecnicosResource {

    @Inject
    DadosTecnicosService dadosTecnicosService;

    //private static final Logger LOG = Logger.getLogger(DadosTecnicosResource.class);
    
    @GET
    public Response findAll() {

        return Response.ok(dadosTecnicosService.findByAll()).build();
    }

    @GET
    @Path("/{id}")
    // @RolesAllowed({"Admin"})
    public DadosTecnicosResponseDTO findById(@PathParam("id") Long id) {
        return dadosTecnicosService.findById(id);
    }

    @POST
    // @RolesAllowed({"Admin"})
    public Response insert(DadosTecnicosDTO dto) {

        DadosTecnicosResponseDTO entity = dadosTecnicosService.create(dto);

        //return Response.status(Status.CREATED).entity(retorno).build();
        return Response.status(201).entity(entity).build();

    }

    @PUT
    @Path("/{id}")
    // @RolesAllowed({"Admin"})
    public Response update(@PathParam("id") Long id, DadosTecnicosDTO dto) {
        dadosTecnicosService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    // @RolesAllowed({"Admin"})
    public Response delete(@PathParam("id") Long id) {
        dadosTecnicosService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}
