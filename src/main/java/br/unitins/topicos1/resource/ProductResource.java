package br.unitins.topicos1.resource;

import br.unitins.topicos1.application.Result;
import br.unitins.topicos1.dto.ProductDTO;
import br.unitins.topicos1.dto.ProductResponseDTO;
import br.unitins.topicos1.service.ProductService;
import jakarta.inject.Inject;

import org.jboss.logging.Logger;


//import br.unitins.topicos1.ecommerce.dto.ProdutoDTO;
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

@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
    
    @Inject
    ProductService productService;

    private static final Logger LOG = Logger.getLogger(ProductResource.class);

    @POST
    public Response insert(ProductDTO dto) {
        LOG.infof("Inserindo um product: %s", dto.nome());

        ProductResponseDTO product = productService.insert(dto);

        LOG.infof("Product (%d) criado com sucesso.", product.id());

       return Response.status(Status.CREATED).entity(product).build();
       
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(ProductDTO dto, @PathParam("id") Long id) {

        try {
            ProductResponseDTO product = productService.update(id, dto);
            return Response.ok(product).build();

        } 
        catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }

        //productService.update(id, dto);
        //return Response.noContent().build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        productService.delete(id);
        return Response.noContent().build();
    }
    
    @GET
    public Response findAll() {
        return Response.ok(productService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(productService.findById(id)).build();
    }
    
    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(productService.findByNome(nome)).build();
    }
}