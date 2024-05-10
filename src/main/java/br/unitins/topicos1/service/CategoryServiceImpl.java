package br.unitins.topicos1.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.CategoryDTO;
import br.unitins.topicos1.dto.CategoryResponseDTO;
import br.unitins.topicos1.model.Category;
import br.unitins.topicos1.repository.CategoryRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CategoryServiceImpl implements CategoryService{

    @Inject
    CategoryRepository categoryRepository;

    @Inject
    Validator validator;

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
        entity.setCompatibilidade(dto.compatibilidade());
        entity.setTipoMola(dto.tipoMola());
        entity.setTipoAmortecedor(dto.tipoAmortecedor());

        // atributo novo
        //entity.setMaterial(dto.material());
        
        categoryRepository.persist(entity);

        return CategoryResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public CategoryResponseDTO update(Long id, CategoryDTO dto) throws ConstraintViolationException{
        validar(dto);

        Category entity = categoryRepository.findById(id);

        entity.setCategory(dto.category());
        entity.setCompatibilidade(dto.compatibilidade());
        entity.setTipoMola(dto.tipoMola());
        entity.setTipoAmortecedor(dto.tipoAmortecedor());
        //entity.setMaterial(dto.material());
        
        return CategoryResponseDTO.valueOf(entity);
    }

    private void validar(CategoryDTO dto) throws ConstraintViolationException {
        Set<ConstraintViolation<CategoryDTO>> violations = validator.validate(dto);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryResponseDTO> findByAll() {
        return categoryRepository.listAll().stream()
            .map(CategoryResponseDTO::valueOf).toList();
    }

    @Override
    public List<CategoryResponseDTO> findByNome(String nome, int page, int pageSize) {
        List<Category> list = categoryRepository.findByNome(nome).page(page, pageSize).list();
        return list.stream().map(e -> CategoryResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return categoryRepository.count();
    }

    @Override
    public long countByNome(String nome) {
        return categoryRepository.findByNome(nome).count();
    }

    // @Override
    // public List<CategoryResponseDTO> findByAll() {
    //     return cupomRepository.listAll().stream()
    //             .map(CupomResponseDTO::valueOf)
    //             .toList();
    // }
    
}