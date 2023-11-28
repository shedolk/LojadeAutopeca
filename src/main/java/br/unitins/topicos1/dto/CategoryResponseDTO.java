package br.unitins.topicos1.dto;

import br.unitins.topicos1.modelo.Category;

public record CategoryResponseDTO(

    Long id,
    String category
) {
    
    public static CategoryResponseDTO valueOf(Category category) {
        return new CategoryResponseDTO(
            category.getId(), 
            category.getCategory()
        );
    }
}
