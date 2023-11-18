package br.unitins.topicos1;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.ClienteResponseDTO;
import br.unitins.topicos1.dto.EnderecoDTO;
import br.unitins.topicos1.service.ClienteService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class ClienteResourceTest {

    @Inject
    ClienteService clienteService;

    @Test
    public void testFindAll() {
        given()
          .when().get("/clientes")
          .then()
             .statusCode(200);
    }

   @Test
  public void testInsert(){

        List<EnderecoDTO> enderecos = new ArrayList<EnderecoDTO>();
        enderecos.add(new EnderecoDTO("Avenida matheus", "124", "Palmas", "Tocantins", "12345-678"));

        ClienteDTO dto = new ClienteDTO(
          "Joao Insert", 
          "joao", 
          "1233", 
          2, 
          "joao@gmail.com", 
          enderecos);

        /* 
        ClienteDTO dto = new ClienteDTO(
           "Cliente 4",
           "cliente4@email.com",
            enderecos);
        */

        given()
        .contentType(ContentType.JSON)
        .body(dto)
        .when().post("/clientes")
        .then()
        .statusCode(201)
        .body("id", notNullValue(), "nome",is("Joao Insert"),"Email",is("joao@gmail.com"));
    }

    @Test
    public void testUpdate(){

        List<EnderecoDTO> enderecos = new ArrayList<EnderecoDTO>();
        enderecos.add(new EnderecoDTO("Avenida matheus", "124", "Palmas", "Tocantins", "12345-678"));

        ClienteDTO dto = new ClienteDTO(
          "Joao Update",
          "joao",
          "1233",
          2,
          "joao@gmail.com", enderecos);

        ClienteResponseDTO clienteTest = clienteService.insert(dto);
        Long id = clienteTest.id();

        //enderecos.add(new EnderecoDTO("filipe lindo", "124", "Palmas", "Tocantins", "12345-678"));

        ClienteDTO dtoUpdate = new ClienteDTO("Joao Jose",
          "john",
          "1244",
          2,
          "joaojose@gmail.com", enderecos);

        given()
        .contentType(ContentType.JSON)
        .body(dtoUpdate)
        .when().put("/clientes/"+ id)
        .then()
        .statusCode(204)
        .body("id", notNullValue(), "nome",is("Joao Jose"),"email",is("joaojose@email.com"));
    }

    
}

