package dev.first.core.useCase.getProducts.io;

import java.time.LocalDateTime;

public record GetProductsContentBoundaryOutput(String name, Integer quantity, String description,
                                               LocalDateTime expiry_date) {
}
