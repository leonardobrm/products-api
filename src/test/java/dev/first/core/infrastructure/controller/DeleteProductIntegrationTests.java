package dev.first.core.infrastructure.controller;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class DeleteProductIntegrationTests {

    @Test
    @DisplayName("deve executar com sucesso")
    void shouldRunSuccessfully() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/v1/product/48")
                .then()
                .statusCode(204);
    }

    @Test
    @DisplayName("deve retonar mensagem de produto não encontado")
    void shouldReturnProductNotFoundMessage() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/v1/product/99999")
                .then()
                .statusCode(404)
                .body(is("Product not found"));
    }
}
