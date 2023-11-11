package dev.first.core.infrastructure.controller.utils;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public final class DataBaseUtils {

    private DataBaseUtils() {
    }

    public static <T> void insert(final T body) {
        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/v1/product");
    }

    public static void delete(final Long id) {
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/v1/product/" + id);
    }
}
