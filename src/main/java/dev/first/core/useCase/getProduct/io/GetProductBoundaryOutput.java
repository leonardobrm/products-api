package dev.first.core.useCase.getProduct.io;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record GetProductBoundaryOutput(Long id, String name, Integer quantity, String description,
                                       LocalDateTime expiry_date) {
}
