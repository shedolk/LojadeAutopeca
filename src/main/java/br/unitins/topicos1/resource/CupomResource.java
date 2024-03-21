package br.unitins.topicos1.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.topicos1.application.Result;
import br.unitins.topicos1.dto.CupomDTO;
import br.unitins.topicos1.dto.CupomResponseDTO;
import br.unitins.topicos1.service.CupomService;
import jakarta.inject.Inject;
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

@Path("/cupons")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CupomResource {

    @Inject
    CupomService cupomService;

    private static final Logger LOG = Logger.getLogger(CupomResource.class);

    @POST
    // @RolesAllowed({ "Admin" })
    public Response insert(CupomDTO dto) {
        LOG.infof("Inserindo um cupom: %s", dto.nomeCupom());

        CupomResponseDTO cupom = cupomService.insert(dto);
        LOG.infof("Cupom (%s) criado com sucesso.", cupom.nomeCupom());
        return Response.status(Status.CREATED).entity(cupom).build();
    }

    @PUT
    @Path("/{id}")
    // @RolesAllowed({ "Admin" })
    public Response update(@PathParam("id") Long id, CupomDTO dto) {
        try {
            CupomResponseDTO cupom = cupomService.update(id, dto);
            return Response.ok(cupom).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Path("/{id}")
    // @RolesAllowed({ "Admin" })
    public Response delete(@PathParam("id") Long id) {
        cupomService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    public Response findByAll() {
        LOG.info("BUSCANDO TODOS OS CUPONS");

        List<CupomResponseDTO> cupons = cupomService.findByAll();
        return Response.ok(cupons).build();
    }

    @GET
    @Path("/{id}")
    // @RolesAllowed({ "Admin" })
    public CupomResponseDTO findById(@PathParam("id") Long id) {
        return cupomService.findById(id);
    }

}
