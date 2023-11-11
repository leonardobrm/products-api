package dev.first.core.infrastructure.factory.controller.request;

import dev.first.infrastructure.controller.request.UpdateProductRequest;

public final class UpdateProductRequestFactory {

    private UpdateProductRequestFactory() {
    }

    public static UpdateProductRequest getDefault() {
        return UpdateProductRequest.builder()
                .name("bola de futebol")
                .description("bola de futebol")
                .quantity(2)
                .expiry_date("10-10-1999")
                .build();
    }
}
