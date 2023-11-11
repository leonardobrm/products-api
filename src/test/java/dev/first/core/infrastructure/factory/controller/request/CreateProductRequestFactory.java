package dev.first.core.infrastructure.factory.controller.request;

import dev.first.infrastructure.controller.request.CreateProductRequest;

public final class CreateProductRequestFactory {

    private CreateProductRequestFactory() {
    }

    public static CreateProductRequest getDefault() {
        return CreateProductRequest.builder()
                .name("Bola de futebol")
                .description("bola de futebol")
                .quantity(2)
                .expiry_date("10-10-1999")
                .build();
    }
}
