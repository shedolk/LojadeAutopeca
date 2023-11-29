package br.unitins.topicos1;



import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

//import java.util.ArrayList;
//import java.util.List;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.ProductDTO;
import br.unitins.topicos1.dto.ProductResponseDTO;
import br.unitins.topicos1.service.CategoryService;
import br.unitins.topicos1.service.ProductService;

//import br.unitins.topicos1.ecommerce.dto.CategoryDTO;
//import br.unitins.topicos1.ecommerce.dto.CategoryResponseDTO;
//import br.unitins.topicos1.ecommerce.dto.CategoryResponseDTO;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

@QuarkusTest
public class ProductResourceTest {
    
    @Inject
    ProductService productService;

    @Inject
    CategoryService categoryService;

    @Test
    public void testFindAll() {
        given()
          .when().get("/products")
          .then()
             .statusCode(200);
    }

    @Test
    @TestSecurity(authorizationEnabled = false)
    public void testInsert() {

        ProductDTO productDTO = new ProductDTO(
            "Produto Insert",
            "Descricao produto insert",
            (long) 1,
            199.00,
            100,
            "nomeImagem"
        );

        given()
        .contentType(ContentType.JSON)
        .body(productDTO)
        .when().post("/products")
        .then()
        .statusCode(201)
        .body(
            "id", notNullValue(),
         "nome",is("Produto Insert"),
         "descricao",is("Descricao produto insert"));
    }

    @Test
    @TestSecurity(authorizationEnabled = false)
    public void testUpdate() {

        //CategoryDTO category = new CategoryDTO("CATEGORY 1");

        ProductDTO productDTO = new ProductDTO("mechanic", "description", (long)1, 299.00, 100, "nomeImagem");

        // inserindo uma product
        ProductResponseDTO productTest = productService.insert(productDTO);

        Long id = productTest.id();

        ProductDTO dtoUpdate = new ProductDTO("MECHANIC 2.0", "description", (long)1, 399.00, 50, "nomeImagem");

        given()
            .contentType(ContentType.JSON)
            .body(dtoUpdate)
            .when().put("/products/"+ id)
            .then()
            .statusCode(200);
    }

}