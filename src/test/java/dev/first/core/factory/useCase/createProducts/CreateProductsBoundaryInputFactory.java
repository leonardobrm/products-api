package dev.first.core.factory.useCase.createProducts;

import dev.first.core.useCase.createProduct.io.CreateProductBoundaryInput;

import java.util.Date;

public final class CreateProductsBoundaryInputFactory {

    private CreateProductsBoundaryInputFactory() {
    }

    public static CreateProductBoundaryInput getWithNullValues() {
        return CreateProductBoundaryInput.builder().build();
    }

    public static CreateProductBoundaryInput getWithEmptyValues() {
        return CreateProductBoundaryInput.builder()
                .name("")
                .description("")
                .build();
    }

    public static CreateProductBoundaryInput getWithquantityLessThanZero() {
        return CreateProductBoundaryInput.builder()
                .name("Bola de futebol")
                .description("bola de futebol")
                .quantity(-1)
                .expiry_date("08/10/2023")
                .build();
    }

    public static CreateProductBoundaryInput getWithquantityEqualToZero() {
        return CreateProductBoundaryInput.builder()
                .name("Bola de futebol")
                .description("bola de futebol")
                .quantity(0)
                .expiry_date("08/10/2023")
                .build();
    }

    public static CreateProductBoundaryInput getInvalidDate() {
        return CreateProductBoundaryInput.builder()
                .name("Bola de futebol")
                .description("bola de futebol")
                .quantity(2)
                .expiry_date("DATA INVALIDA")
                .build();
    }

    public static CreateProductBoundaryInput getDefault() {
        return CreateProductBoundaryInput.builder()
                .name("Bola de futebol")
                .description("bola de futebol")
                .quantity(2)
                .expiry_date("10/10/1999")
                .build();
    }
}
