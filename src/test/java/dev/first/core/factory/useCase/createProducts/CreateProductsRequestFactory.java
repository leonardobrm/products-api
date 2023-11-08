package dev.first.core.factory.useCase.createProducts;

import dev.first.infrastructure.controller.request.CreateProductRequest;

public final class CreateProductsRequestFactory {

    private CreateProductsRequestFactory() {
    }

    public static CreateProductRequest getWithNullValues() {
        return CreateProductRequest.builder().build();
    }

    public static CreateProductRequest getWithEmptyValues() {
        return CreateProductRequest.builder()
                .name("")
                .description("")
                .build();
    }

    public static CreateProductRequest getWithquantityLessThanZero() {
        return CreateProductRequest.builder()
                .name("Bola de futebol")
                .description("bola de futebol")
                .quantity(-1)
                .expiry_date("08/10/2023")
                .build();
    }

    public static CreateProductRequest getWithquantityEqualToZero() {
        return CreateProductRequest.builder()
                .name("Bola de futebol")
                .description("bola de futebol")
                .quantity(0)
                .expiry_date("08/10/2023")
                .build();
    }

    public static CreateProductRequest getInvalidDate() {
        return CreateProductRequest.builder()
                .name("Bola de futebol")
                .description("bola de futebol")
                .quantity(2)
                .expiry_date("DATA INVALIDA")
                .build();
    }

    public static CreateProductRequest getDefault() {
        return CreateProductRequest.builder()
                .name("Bola de futebol")
                .description("bola de futebol")
                .quantity(2)
                .expiry_date("10/10/1999")
                .build();
    }
}
