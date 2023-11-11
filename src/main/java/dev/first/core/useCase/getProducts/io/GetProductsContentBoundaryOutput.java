package dev.first.core.useCase.getProducts.io;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
public record GetProductsContentBoundaryOutput(Long id, String name, Integer quantity, String description,
                                               LocalDateTime expiry_date) {
}
