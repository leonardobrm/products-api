package dev.first.core.useCase.updateProduct.io;

import lombok.Builder;

@Builder
public record UpdateProductBoundaryInput(String name, Integer quantity, String description, String expiry_date) {
}
