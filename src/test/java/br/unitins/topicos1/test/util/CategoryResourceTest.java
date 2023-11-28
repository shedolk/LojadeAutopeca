package br.unitins.topicos1.test.util;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

//import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.CategoryDTO;
import br.unitins.topicos1.dto.CategoryResponseDTO;
import br.unitins.topicos1.service.CategoryService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

@QuarkusTest
public class CategoryResourceTest {
    
    @Inject
    CategoryService categoryService;


    @Test
    public void testFindAll() {
        given()
          .when().get("/categories")
          .then()
             .statusCode(200);
    }

    @Test
    public void testInsert(){

        CategoryDTO dto = new CategoryDTO(
            "Baterias"
            );

        given()
        .contentType(ContentType.JSON)
        .body(dto)
        .when().post("/categories")
        .then()
        .statusCode(201)
        .body(
            "id", notNullValue(),
        "category", is("Baterias")
        );
}

    @Test
    public void testUpdate() {

        CategoryDTO categoryDTO = new CategoryDTO("Baterias"); 
        
        // inserindo uma category
        CategoryResponseDTO categoryTest = categoryService.create(categoryDTO);

        Long id = categoryTest.id();

        CategoryDTO dtoUpdate = new CategoryDTO("BATERIA ELETRIC CAR");

        given()
            .contentType(ContentType.JSON)
            .body(dtoUpdate)
            .when().put("/categories/"+ id)
            .then()
            .statusCode(200);
    }
}