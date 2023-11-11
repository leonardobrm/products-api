package dev.first.infrastructure.controller.request;

import lombok.Builder;

@Builder
public record CreateProductRequest(String name, Integer quantity, String description, String expiry_date) {
}
