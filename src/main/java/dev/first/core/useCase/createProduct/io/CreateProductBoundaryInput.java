package dev.first.core.useCase.createProduct.io;

import lombok.Builder;

@Builder
public record CreateProductBoundaryInput(String name, Integer quantity, String description, String expiry_date) {
}
