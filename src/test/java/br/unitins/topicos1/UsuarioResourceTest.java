package br.unitins.topicos1;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.EnderecoDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.UsuarioDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.service.UsuarioService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class UsuarioResourceTest {

    @Inject
    UsuarioService usuarioService;


    @Test
    public void testFindAll() {
        given()
          .when().get("/usuarios")
          .then()
             .statusCode(200);
    }
    @Test
    @TestSecurity(authorizationEnabled = false)
    public void testInsert(){
        List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
        telefones.add(new TelefoneDTO("63","5555-5555"));
        List<EnderecoDTO> enderecos = new ArrayList<EnderecoDTO>();
        enderecos.add(new EnderecoDTO("rua 1", "numero1", "cidade 1", "estado 1", "123456789"));

        UsuarioDTO dto = new UsuarioDTO(
            "Joao Insert",
            "joaozinho",
            "1234",
            "12345678911",
            2, 
            telefones,
            enderecos);

        given()
        .contentType(ContentType.JSON)
        .body(dto)
        .when().post("/usuarios")
        .then()
        .statusCode(201)
        .body(
            "id", notNullValue(),
         "nome",is("Joao Insert"),
         "login",is("joaozinho")
        );
    }
    
    @Test
    @TestSecurity(authorizationEnabled = false)
    public void testUpdate(){
        List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
        telefones.add(new TelefoneDTO("63","1111-1111"));
        List<EnderecoDTO> enderecos = new ArrayList<EnderecoDTO>();
        enderecos.add(new EnderecoDTO("rua 1", "numero1", "cidade 1", "estado 1", "123456789"));

        UsuarioDTO dto = new UsuarioDTO(
             "Ronaldo Fenomeno",
            "ronaldo",
            "333",
            "12345678911",
            2,
            telefones,
            enderecos);

        UsuarioResponseDTO usuarioTest = usuarioService.insert(dto);

        Long id = usuarioTest.id();
        telefones.add(new TelefoneDTO("63","5555-5555"));
        UsuarioDTO dtoUpdate = new UsuarioDTO(
             "Angel Romero",
            "romero",
            "345",
            "12345678900",
            1, 
            telefones, enderecos);

        given()
        .contentType(ContentType.JSON)
        .body(dtoUpdate)
        .when().put("/usuarios/"+ id)
        .then()
        .statusCode(204);

        // Verificando se os dados foram atualizados no banco de dados
        UsuarioResponseDTO usuarioResponseDTO = usuarioService.findById(id);
        assertThat(usuarioResponseDTO.nome(), is("Angel Romero"));
        assertThat(usuarioResponseDTO.cpf(), is("12345678900"));
    }

        @Test
        @TestSecurity(authorizationEnabled = false)
        public void testDelete() {

            List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
            telefones.add(new TelefoneDTO("63","1111-1111"));
            List<EnderecoDTO> enderecos = new ArrayList<EnderecoDTO>();
            enderecos.add(new EnderecoDTO("rua 10", "numero10", "Palmas", "Tocantins","123456789"));

            // Adicionando uma pessoa no banco de dados
            UsuarioDTO usuario = new UsuarioDTO(
                "Filipe",
                "lilipe", 
                "1111", 
                "123456789", 
                1, 
                telefones, 
                enderecos
            );


            Long id = usuarioService.insert(usuario).id();
            given()
            .when().delete("/usuarios/" + id)
            .then()
            .statusCode(204);

            // verificando se o usuario foi excluida
            UsuarioResponseDTO usuarioResponseDTO = null;
                try {
                usuarioService.findById(id);
                } catch (Exception e) {
                }
                finally {
                    assertNull(usuarioResponseDTO); 
                } 
        
        }


}