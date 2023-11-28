package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryDTO(

    @NotBlank(message = "Informe o nome da categoria.")
    @Size(max = 60, message = "O campo deve possuir no máximo 60 caracteres.")
    String category  
    
) {

} 
