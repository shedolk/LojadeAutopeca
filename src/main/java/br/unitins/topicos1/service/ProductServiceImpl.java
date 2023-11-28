package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ProductDTO;
import br.unitins.topicos1.dto.ProductResponseDTO;
import br.unitins.topicos1.model.Product;
import br.unitins.topicos1.repository.CategoryRepository;
import br.unitins.topicos1.repository.ProductRepository;

//import br.unitins.topicos1.ecommerce.dto.ProdutoResponseDTO;
//import br.unitins.topicos1.ecommerce.model.Categoria;

//import br.unitins.topicos1.ecommerce.model.Produto;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ProductServiceImpl implements ProductService{

    @Inject
    ProductRepository productRepository;

    @Inject
    CategoryRepository categoryRepository;

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
    
}