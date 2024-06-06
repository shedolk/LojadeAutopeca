package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Category;

public record CategoryResponseDTO(

        Long id,
        String category,
        String compatibilidade,
        String tipoMola,
        String tipoAmortecedor) {

    public static CategoryResponseDTO valueOf(Category category) {

        if (category == null) {
            return null; // Ou lançar uma exceção, dependendo do seu requisito
        }

        return new CategoryResponseDTO(
                category.getId(),
                category.getCategory(),
                category.getCompatibilidade(),
                category.getTipoMola(),
                category.getTipoAmortecedor());
    }
}
