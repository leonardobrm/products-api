package dev.first.core.factory.useCase.updateProduct;

import dev.first.core.useCase.updateProduct.io.UpdateProductBoundaryInput;

public final class UpdateProductBoundaryInputFactory {

    private UpdateProductBoundaryInputFactory() {
    }

    public static UpdateProductBoundaryInput getWithNullValues() {
        return UpdateProductBoundaryInput.builder().build();
    }

    public static UpdateProductBoundaryInput getWithEmptyValues() {
        return UpdateProductBoundaryInput.builder()
                .name("")
                .description("")
                .build();
    }

    public static UpdateProductBoundaryInput getWithquantityLessThanZero() {
        return UpdateProductBoundaryInput.builder()
                .name("Bola de futebol")
                .description("bola de futebol")
                .quantity(-1)
                .expiry_date("08-10-2023")
                .build();
    }

    public static UpdateProductBoundaryInput getWithquantityEqualToZero() {
        return UpdateProductBoundaryInput.builder()
                .name("Bola de futebol")
                .description("bola de futebol")
                .quantity(0)
                .expiry_date("08-10-2023")
                .build();
    }

    public static UpdateProductBoundaryInput getInvalidDate() {
        return UpdateProductBoundaryInput.builder()
                .name("Bola de futebol")
                .description("bola de futebol")
                .quantity(2)
                .expiry_date("DATA INVALIDA")
                .build();
    }

    public static UpdateProductBoundaryInput getDefault() {
        return UpdateProductBoundaryInput.builder()
                .name("bola de futebol")
                .description("bola de futebol")
                .quantity(2)
                .expiry_date("10-10-1999")
                .build();
    }
}
