package br.unitins.topicos1.resource;

import br.unitins.topicos1.application.Result;
import br.unitins.topicos1.dto.ProductDTO;
import br.unitins.topicos1.dto.ProductResponseDTO;
import br.unitins.topicos1.form.ProductImageForm;
import br.unitins.topicos1.service.ProductFileService;
import br.unitins.topicos1.service.ProductService;
//import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;

import br.unitins.topicos1.util.Error;

import java.io.IOException;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

@Path("/produtos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    ProductService productService;

    @Inject
    ProductFileService productFileService;

    private static final Logger LOG = Logger.getLogger(ProductResource.class);

    

    @POST
    //@RolesAllowed({"Admin"})
    //@Path("/{new}")
    public Response insert(ProductDTO dto) {
        LOG.infof("Inserindo um product: %s", dto.nome());

        ProductResponseDTO product = productService.insert(dto);

        LOG.infof("Product (%d) criado com sucesso.", product.id());

        return Response.status(Status.CREATED).entity(product).build();

    }

    @PUT
    @Transactional
    @Path("/{id}")
   // @RolesAllowed({"Admin"})
    public Response update(ProductDTO dto, @PathParam("id") Long id) {

        try {
            ProductResponseDTO product = productService.update(id, dto);
            return Response.ok(product).build();

        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }

    }

    @DELETE
    @Transactional
    @Path("/{id}")
    //@RolesAllowed({"Admin"})
    public Response delete(@PathParam("id") Long id) {
        productService.delete(id);
        return Response.noContent().build();
    }

    @GET
    //@RolesAllowed("User")
    public Response findAll(
                @QueryParam("page") @DefaultValue("0") int page,
                @QueryParam("pageSize") @DefaultValue("100") int pageSize) {

        return Response.ok(productService.getAll(page, pageSize)).build();
    }

    // @GET
    // public Response findAll() {
    //     return Response.ok(productService.findAll()).build();
    // }

    @GET
    @Path("/{id}")
    // @RolesAllowed({"Admin"})
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(productService.findById(id)).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(productService.findByNome(nome)).build();
    }

    @GET
    @Path("/count")
    public long count(){
        return productService.count();
    }

    @PATCH
    //@RolesAllowed({"Admin"})
    @Path("/upload/imagem/{id}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@MultipartForm ProductImageForm form, @PathParam("id") Long id) {
        String nomeImagem;
        try {
            nomeImagem = productFileService.salvar(form.getNomeImagem(), form.getImagem());
        } catch (IOException e) {
            e.printStackTrace();
            Error error = new Error("409", e.getMessage());
            return Response.status(Status.CONFLICT).entity(error).build();
        }

        productService.updateNomeImagem(id, nomeImagem);

        return Response.ok(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/download/imagem/{nomeImagem}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@PathParam("nomeImagem") String nomeImagem) {
        ResponseBuilder response = Response.ok(productFileService.obter(nomeImagem));
        response.header("Content-Disposition", "attachment;filename=" + nomeImagem);
        return response.build();
    }
}