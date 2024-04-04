package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.CategoryDTO;
import br.unitins.topicos1.dto.CategoryResponseDTO;
import jakarta.validation.Valid;

public interface CategoryService {

    CategoryResponseDTO findById(Long id);
    
    CategoryResponseDTO create(@Valid CategoryDTO dto);
    
    CategoryResponseDTO update(Long id, CategoryDTO dto);
    
    void delete(Long id);

    public List<CategoryResponseDTO> findByAll();

    List<CategoryResponseDTO> findByNome(String category, int page, int pageSize);
    
    long count();

    long countByNome(String nome);
} 
