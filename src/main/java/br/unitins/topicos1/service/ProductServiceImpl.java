package br.unitins.topicos1.service;

import java.io.IOException;
import java.util.List;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.topicos1.dto.ProductDTO;
import br.unitins.topicos1.dto.ProductResponseDTO;
import br.unitins.topicos1.form.ProductImageForm;
import br.unitins.topicos1.model.Product;
import br.unitins.topicos1.repository.CategoryRepository;
import br.unitins.topicos1.repository.ProductRepository;

import br.unitins.topicos1.util.Error;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@ApplicationScoped
public class ProductServiceImpl implements ProductService{

    @Inject
    ProductRepository productRepository;

    @Inject
    CategoryRepository categoryRepository;

    @Inject
    ProductFileService productFileService;

    @Override
    @Transactional
    public ProductResponseDTO insert(@Valid ProductDTO dto) {
        Product novoProduct = new Product();
        novoProduct.setNome(dto.nome());
        novoProduct.setDescricao(dto.descricao());

        novoProduct.setCategory(categoryRepository.findById(dto.idCategory()));

        novoProduct.setPreco(dto.preco());
        novoProduct.setEstoque(dto.estoque());
       
        productRepository.persist(novoProduct);

       return ProductResponseDTO.valueOf(novoProduct);
    }

    @Override
    @Transactional
    public ProductResponseDTO update(Long id, ProductDTO dto) {
        Product product = productRepository.findById(id);

        if (productRepository.findById(id) == null || product.getId() == null) {

            product.setId(id);
            product.setNome(dto.nome());
            product.setDescricao(dto.descricao());

            product.setCategory(categoryRepository.findById(dto.idCategory()));

            product.setPreco(dto.preco());
            product.setEstoque(dto.estoque());
        }

        return ProductResponseDTO.valueOf(product);
    }
    

    @Override
    @Transactional
    public void delete(Long id) {
        if (!productRepository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public ProductResponseDTO findById(Long id) {
        return ProductResponseDTO.valueOf(productRepository.findById(id));
    }

    @Override
    public List<ProductResponseDTO> findAll() {
        return productRepository.listAll().stream()
                .map(e -> ProductResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ProductResponseDTO> findByNome(String nome) {
        return productRepository.findByNome(nome).stream()
                .map(e -> ProductResponseDTO.valueOf(e)).toList();
    }

    @Override
    public void updateNomeImagem(Long id, String nomeImagem) {
        Product produto = productRepository.findById(id);

        if (produto == null)
            throw new NullPointerException("Nenhum produto encontrado");
            
        produto.setNomeImagem(nomeImagem);
    }
    
    @PATCH
    @Path("/upload/imagem/{id}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@MultipartForm ProductImageForm form,@PathParam("id") Long id ){
        try {
           productFileService.salvar(form.getNomeImagem(), form.getImagem());
        } catch (IOException e) {
            e.printStackTrace();
            Error error = new Error("409", e.getMessage());
            return Response.status(Status.CONFLICT).entity(error).build();
        }

       
     ((ProductService) productFileService).updateNomeImagem(id, form.getNomeImagem());

        return Response.ok(Status.NO_CONTENT).build();

    }

}