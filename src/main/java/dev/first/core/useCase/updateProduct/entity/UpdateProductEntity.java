package dev.first.core.useCase.updateProduct.entity;

import dev.first.core.data.product.io.UpdateProductDataBaseInput;
import dev.first.core.useCase.updateProduct.io.UpdateProductBoundaryInput;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public final class UpdateProductEntity {

    private UpdateProductEntity() {
    }

    public static UpdateProductDataBaseInput createDataBaseInput(final UpdateProductBoundaryInput input) {
        log.info("input={}", input);
        final var output = UpdateProductDataBaseInput.builder()
                .name(input.name())
                .description(input.description())
                .quantity(input.quantity())
                .expiry_date(convertStringToDate(input.expiry_date()))
                .build();
        log.info("output={}", output);
        return output;
    }

    private static LocalDateTime convertStringToDate(final String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date, formatter).atStartOfDay();
    }
}
