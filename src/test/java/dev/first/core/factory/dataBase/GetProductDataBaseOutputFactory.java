package dev.first.core.factory.dataBase;

import dev.first.core.data.product.io.GetProductDataBaseOutput;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class GetProductDataBaseOutputFactory {

    private GetProductDataBaseOutputFactory() {
    }

    public static GetProductDataBaseOutput getDefault() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        final var date = LocalDate.parse("09-11-2023", formatter).atStartOfDay();

        return GetProductDataBaseOutput.builder()
                .id(2L)
                .name("bola de futebol")
                .description("bola de futebol")
                .quantity(1)
                .expiry_date(date)
                .build();
    }
}
