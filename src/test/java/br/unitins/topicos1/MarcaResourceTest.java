package br.unitins.topicos1;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.MarcaDTO;
import br.unitins.topicos1.dto.MarcaResponseDTO;
import br.unitins.topicos1.dto.ProdutoDTO;
import br.unitins.topicos1.service.MarcaService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;


@QuarkusTest
public class MarcaResourceTest {

    @Inject
    MarcaService marcaService;

    @Test
    public void testInsert(){
        
        List<ProdutoDTO> produtos = new ArrayList<ProdutoDTO>();
        produtos.add(new ProdutoDTO("Produto 2", "Kit mecanica Gurgel", 999.99, 5));

        MarcaDTO dto = new MarcaDTO(
            "Gurgel",
        "Origem Brasileira, ha mais de 20 anos no mercado",
                produtos);

        given()
        .contentType(ContentType.JSON)
        .body(dto)
        .when().post("/marcas")
        .then()
        .statusCode(201)
        .body(
            "id", notNullValue(),
            "nome", is("Gurgel"),
            "descricao", is("Origem Brasileira, ha mais de 20 anos no mercado")
        );
}

    @Test
    public void testUpdate() {
        List<ProdutoDTO> produtos = new ArrayList<ProdutoDTO>();
        produtos.add(new ProdutoDTO("Produto 10", "Kit mecanica Fiat Escada", 1999.99, 3));

        MarcaDTO marcaDTO = new MarcaDTO("Gurgel", "Origem Brasileira, ha mais de 20 anos no mercado",produtos); 
        
        // inserindo uma marca
        MarcaResponseDTO marcaTest = marcaService.insert(marcaDTO);

        Long id = marcaTest.id();

        MarcaDTO dtoUpdate = new MarcaDTO("Gurgel 2.0", "Origem Brasileira, ha mais de 30 anos no mercado",produtos);

        given()
            .contentType(ContentType.JSON)
            .body(dtoUpdate)
            .when().put("/marcas/"+ id)
            .then()
            .statusCode(204);
    }
}
