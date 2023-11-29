package br.unitins.topicos1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.CategoryDTO;
import br.unitins.topicos1.dto.CategoryResponseDTO;
import br.unitins.topicos1.service.CategoryService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
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
    @TestSecurity(authorizationEnabled = false)
    public void testInsert(){

        CategoryDTO dto = new CategoryDTO(
            "BATERIAS"
            );

        given()
        .contentType(ContentType.JSON)
        .body(dto)
        .when().post("/categories")
        .then()
        .statusCode(201)
        .body(
            "id", notNullValue(),
        "category", is("BATERIAS")
        );
}

    @Test
    @TestSecurity(authorizationEnabled = false)
    public void testUpdate() {

        CategoryDTO categoryDTO = new CategoryDTO("Baterias"); 
        
        // inserindo uma category
        CategoryResponseDTO categoryTest = categoryService.create(categoryDTO);

        Long id = categoryTest.id();

        CategoryDTO dtoUpdate = new CategoryDTO("MOTOR ELETRICO");

        given()
            .contentType(ContentType.JSON)
            .body(dtoUpdate)
            .when().put("/categories/"+ id)
            .then()
            .statusCode(200);
    }
}
