package dev.first.core.useCase.getProducts.io;

import java.time.LocalDateTime;

public record GetProductsContentBoundaryOutput(Long id, String name, Integer quantity, String description,
                                               LocalDateTime expiry_date) {
}
