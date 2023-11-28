package br.unitins.topicos1;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.service.PedidoService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import jakarta.inject.Inject;

@QuarkusTest
public class PedidoResourceTest {
    
    @Inject
    PedidoService pedidoService;

    @Test
    @TestSecurity(authorizationEnabled = false)
    public void testFindAll() {
        given()
          .when().get("/pedidos")
          .then()
             .statusCode(200);
    }


}


