package dev.first.core.infrastructure.controller;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class GetProductsIntegrationTests {

    @BeforeAll
    static void insertRecordInDataBase() {
        //DataBaseUtils.insert(CreateProductsRequestFactory.getDefault());
        // DataBaseUtils.insert(CreateProductsRequestFactory.getDefault());
    }

    @AfterAll
    static void removeRecordInDataBase() {
        //DataBaseUtils.delete();
        //DataBaseUtils.delete();
    }

    @Test
    @DisplayName("deve executar com sucesso")
    void shouldRunSuccessfully() {
        given()
                .contentType(ContentType.JSON)
                .queryParam("page", 0)
                .queryParam("size", 2)
                .when()
                .get("/v1/product")
                .then()
                .statusCode(200);
    }
}
