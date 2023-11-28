package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ProductDTO;
import br.unitins.topicos1.dto.ProductResponseDTO;
import jakarta.validation.Valid;

public interface ProductService {

    ProductResponseDTO insert(@Valid ProductDTO dto);
    
    ProductResponseDTO update(Long id, ProductDTO dto);

    void delete(Long id);

    ProductResponseDTO findById(Long id);

    List<ProductResponseDTO> findAll();

    List<ProductResponseDTO> findByNome(String nome);
}
