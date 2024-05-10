package br.unitins.topicos1;

// import static io.restassured.RestAssured.given;
// //import static org.hamcrest.CoreMatchers.is;
// import static org.hamcrest.CoreMatchers.notNullValue;
// import static org.junit.jupiter.api.Assertions.assertEquals;

// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;

// import org.junit.jupiter.api.Test;

// import br.unitins.topicos1.dto.ItemPedidoDTO;
// import br.unitins.topicos1.dto.PedidoDTO;
// import br.unitins.topicos1.resource.PedidoResource;
// import br.unitins.topicos1.service.PedidoService;
// import io.quarkus.test.junit.QuarkusTest;
// import io.quarkus.test.security.TestSecurity;
// import io.restassured.http.ContentType;
// import jakarta.inject.Inject;
// import jakarta.ws.rs.core.Response;

// @QuarkusTest
// public class PedidoResourceTest {

    // @Inject
    // PedidoService pedidoService;

    // @Inject
    // PedidoResource pedidoResource;

    // /*
    // @Test
    // @TestSecurity(authorizationEnabled = false)
    // public void testFindAll() {
    // given()
    // .when().get("/pedidos")
    // .then()
    // .statusCode(200);
    // }*/

    // @Test
    // @TestSecurity(authorizationEnabled = false)
    // public void testFindAll() {

    // Response response = pedidoResource.findAll();

    // assertEquals(200, response.getStatus());

    // }

    // @Test
    // @TestSecurity(authorizationEnabled = false)
    // public void testInsert() {

    // List<ItemPedidoDTO> itens = new ArrayList<ItemPedidoDTO>();
    // itens.add(new ItemPedidoDTO(2, 199.00, (long)1));

    // PedidoDTO pedidoDTO = new PedidoDTO(itens, LocalDateTime.now(), 1);

    // given()
    // .contentType(ContentType.JSON)
    // .body(pedidoDTO)
    // .when().post("/pedidos")
    // .then()
    // .statusCode(201)
    // .body(
    // "id", notNullValue());
    // }

    /*
     * @Test
     * 
     * @TestSecurity(authorizationEnabled = false)
     * public void testFindById() {
     * // Configurar objetos fictícios
     * 
     * Long id = 1L;
     * 
     * // Chamar o método e verificar o resultado
     * Response response = pedidoResource.findById(id);
     * 
     * assertEquals(200, response.getStatus());
     * 
     * // Você pode adicionar mais verificações conforme necessário
     * }
     */

//}
