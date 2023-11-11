package dev.first.core.infrastructure.controller;

import dev.first.core.factory.useCase.createProducts.CreateProductsRequestFactory;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class CreateProductIntegrationTests {

    @Test
    @DisplayName("deve executar com sucesso")
    void shouldRunSuccessfully() {
        final var requestBody = CreateProductsRequestFactory.getDefault();

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/v1/product")
                .then()
                .statusCode(201);
    }

    @Test
    @DisplayName("Deve retornar erro de validação quando os campos do input não forem preenchidos")
    void shouldThrowValidationErrorWhenFieldsAreNotFilled() {
        final var requestBody = CreateProductsRequestFactory.getWithNullValues();

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/v1/product")
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("Deve retornar erro de validação quando os campos forem preenchidos com string vazia")
    void shouldThrowValidationErrorWhenFieldsAreFilledWithEmptyString() {
        final var requestBody = CreateProductsRequestFactory.getWithEmptyValues();

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/v1/product")
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("deve retornar erro de validação quando o campo quantity for menor que zero")
    void shouldReturnValidationErrorWhenQuantityIsLessThanZero() {
        final var requestBody = CreateProductsRequestFactory.getWithquantityLessThanZero();

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/v1/product")
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("deve retornar erro de validação quando o campo quantity for zero")
    void shouldReturnValidationErrorWhenQuantityIsequalToZero() {
        final var requestBody = CreateProductsRequestFactory.getWithquantityEqualToZero();

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/v1/product")
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("deve retornar erro de validação quando o campo data não for uma data valida no formato dd-MM-yyyy")
    void shouldReturnValidationErrorWhenDateIsInvalidInFormat() {
        final var requestBody = CreateProductsRequestFactory.getInvalidDate();

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/v1/product")
                .then()
                .statusCode(400);
    }
}
