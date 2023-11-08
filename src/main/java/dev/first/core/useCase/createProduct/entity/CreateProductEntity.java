package dev.first.core.useCase.createProduct.entity;

import dev.first.core.data.product.io.CreateProductDataBaseInput;
import dev.first.core.useCase.createProduct.io.CreateProductBoundaryInput;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class CreateProductEntity {

    private CreateProductEntity() {
    }

    public static CreateProductDataBaseInput createDataBaseInput(final CreateProductBoundaryInput input) {
        return CreateProductDataBaseInput.builder()
                .name(input.name())
                .description(input.description())
                .quantity(input.quantity())
                .expiry_date(convertStringToDate(input.expiry_date()))
                .build();
    }

    private static LocalDate convertStringToDate(final String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       return LocalDate.parse(date, formatter);
    }
}
