package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;



import br.unitins.topicos1.application.Result;
import br.unitins.topicos1.dto.DadosTecnicosDTO;
import br.unitins.topicos1.dto.DadosTecnicosResponseDTO;
import br.unitins.topicos1.service.DadosTecnicosService;
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

@Path("/dadostecnicos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DadosTecnicosResource {

    @Inject
    DadosTecnicosService dadosTecnicosService;

    private static final Logger LOG = Logger.getLogger(DadosTecnicosResource.class);
    
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

        LOG.infof("Inserindo compatibilidade: %s", dto.compatibilidade());
        LOG.infof("Inserindo tipo de mola: %s", dto.tipoMola());
        LOG.infof("Inserindo tipo de amortecedor: %s", dto.tipoAmortecedor());
        LOG.infof("Inserindo fornecedor: %s", dto.fornecedor());
        LOG.infof("Inserindo embalagem: %s", dto.embalagem());
        LOG.infof("Inserindo peso: %s", dto.peso());

        DadosTecnicosResponseDTO dadosTecnicos = dadosTecnicosService.create(dto);

        LOG.infof("Category (%s) criada com sucesso.", dadosTecnicos.compatibilidade());
        return Response.status(Status.CREATED).entity(dadosTecnicos).build();

    }

    @PUT
    @Path("/{id}")
    // @RolesAllowed({"Admin"})
    public Response update(@PathParam("id") Long id, DadosTecnicosDTO dto) {
        try {
            DadosTecnicosResponseDTO dadosTecnicos = dadosTecnicosService.update(id, dto);
            return Response.ok(dadosTecnicos).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Path("/{id}")
    // @RolesAllowed({"Admin"})
    public Response delete(@PathParam("id") Long id) {
        dadosTecnicosService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}
