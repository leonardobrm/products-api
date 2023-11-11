package dev.first.core.factory.useCase.getProduct;

import dev.first.core.useCase.getProduct.io.GetProductBoundaryOutput;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class GetProductBoundaryOutputFactory {

    private GetProductBoundaryOutputFactory() {
    }

    public static GetProductBoundaryOutput getDefault() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        final var date = LocalDate.parse("09-11-2023", formatter).atStartOfDay();

        return GetProductBoundaryOutput.builder()
                .id(2L)
                .name("bola de futebol")
                .description("bola de futebol")
                .quantity(1)
                .expiry_date(date)
                .build();
    }
}
