package dev.first.infrastructure.controller.request;

import lombok.Builder;

@Builder
public record UpdateProductRequest(String name, Integer quantity, String description, String expiry_date) {
}
