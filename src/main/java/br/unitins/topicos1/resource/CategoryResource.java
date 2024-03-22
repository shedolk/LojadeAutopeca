package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

import br.unitins.topicos1.application.Result;
import br.unitins.topicos1.dto.CategoryDTO;
import br.unitins.topicos1.dto.CategoryResponseDTO;
import br.unitins.topicos1.service.CategoryService;
// import jakarta.annotation.security.RolesAllowed;
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

@Path("/categories")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResource {

    @Inject
    CategoryService categoryService;

    private static final Logger LOG = Logger.getLogger(CategoryResource.class);

    @GET
    public Response findAll() {
        LOG.info("BUSCANDO AS CATEGORIAS DE PRODUTOS DA SUA AUTOPECAS");

        return Response.ok(categoryService.findByAll()).build();
    }

    @GET
    @Path("/{id}")
    // @RolesAllowed({"Admin"})
    public CategoryResponseDTO findById(@PathParam("id") Long id) {
        return categoryService.findById(id);
    }

    @POST
    // @RolesAllowed({"Admin"})
    public Response insert(CategoryDTO dto) {
        LOG.infof("Inserindo uma categoria: %s", dto.category());

        CategoryResponseDTO category = categoryService.create(dto);
        LOG.infof("Category (%s) criada com sucesso.", category.category());
        return Response.status(Status.CREATED).entity(category).build();

    }

    @PUT
    @Path("/{id}")
    // @RolesAllowed({"Admin"})
    public Response update(@PathParam("id") Long id, CategoryDTO dto) {
        try {
            CategoryResponseDTO category = categoryService.update(id, dto);
            return Response.ok(category).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Path("/{id}")
    // @RolesAllowed({"Admin"})
    public Response delete(@PathParam("id") Long id) {
        categoryService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}
