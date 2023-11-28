package br.unitins.topicos1.service;

import java.util.List;


import br.unitins.topicos1.dto.CategoryDTO;
import br.unitins.topicos1.dto.CategoryResponseDTO;
import br.unitins.topicos1.modelo.Category;
import br.unitins.topicos1.repository.CategoryRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CategoryServiceImpl implements CategoryService{

    @Inject
    CategoryRepository categoryRepository;


    @Override
    public CategoryResponseDTO findById(Long id) {
        Category category = categoryRepository.findById(id);
        if (category == null)
            throw new NotFoundException("Category não encontrada.");
        return CategoryResponseDTO.valueOf(category);
    }

    @Override
    @Transactional
    public CategoryResponseDTO create(@Valid CategoryDTO dto) {
        
        Category entity = new Category();
        entity.setCategory(dto.category());
        
        categoryRepository.persist(entity);

        return CategoryResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public CategoryResponseDTO update(Long id, CategoryDTO dto) {
        
        Category entity = categoryRepository.findById(id);

        entity.setCategory(dto.category());
        
        return CategoryResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryResponseDTO> findByAll() {
        return categoryRepository.listAll().stream()
            .map(e -> CategoryResponseDTO.valueOf(e)).toList();
    }
    
}