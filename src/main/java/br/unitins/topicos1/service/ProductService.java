package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ProductDTO;
import br.unitins.topicos1.dto.ProductResponseDTO;
import br.unitins.topicos1.form.ProductImageForm;
import jakarta.validation.Valid;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

public interface ProductService {

    ProductResponseDTO insert(@Valid ProductDTO dto);
    
    ProductResponseDTO update(Long id, ProductDTO dto);

    void delete(Long id);

    void updateNomeImagem(Long id, String nomeImagem) ;

    public Response salvarImagem(ProductImageForm form,@PathParam("id") Long id);

    ProductResponseDTO findById(Long id);

    List<ProductResponseDTO> getAll(int page, int pageSize);

    //List<ProductResponseDTO> findAll();

    List<ProductResponseDTO> findByNome(String nome);
}
