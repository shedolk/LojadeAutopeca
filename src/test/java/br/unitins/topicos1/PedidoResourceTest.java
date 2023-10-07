package br.unitins.topicos1;

import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import static io.restassured.RestAssured.given;

import br.unitins.topicos1.service.PedidoService;


@QuarkusTest
public class PedidoResourceTest {

     @Inject
    PedidoService pedidoService;

     @Test
    public void testFindAll() {
        given()
          .when().get("/pedidos")
          .then()
             .statusCode(200);
    }

   /* @Test
    public void testInsert(){
        List<ItemPedidoDTO> itemPedidos = new ArrayList<ItemPedidoDTO>();
        itemPedidos.add(new ItemPedidoDTO(2,5));
        PedidoDTO dto = new PedidoDTO("PEDIDO001", "2023-10-07", 2);

        given()
        .contentType(ContentType.JSON)
        .body(dto)
        .when().post("/pedido")
        .then()
        .statusCode(201)
        .body("id", notNullValue(), "produto",is("PEDIDO001"),"data",is("2023-10-07"));
    }*/
}
