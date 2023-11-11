package dev.first.core.infrastructure.factory.controller.response;

import dev.first.infrastructure.controller.response.GetProductResponse;
import io.quarkus.test.junit.QuarkusTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@QuarkusTest
public final class GetProductResponseFactory {

    private GetProductResponseFactory() {
    }

    public static GetProductResponse getDefault() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        final var date = LocalDate.parse("09-11-2023", formatter).atStartOfDay();

        return GetProductResponse.builder()
                .id(2L)
                .name("bola de futebol")
                .description("bola de futebol")
                .quantity(1)
                .expiry_date(date)
                .build();
    }
}
