package dev.first.core.useCase.getValidProducts.io;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
public record GetValidProductsContentBoundaryOutput(Long id, String name, Integer quantity, String description,
                                                    LocalDateTime expiry_date) {
}
