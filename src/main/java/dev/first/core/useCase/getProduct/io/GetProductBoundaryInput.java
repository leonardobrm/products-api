package dev.first.core.useCase.getProduct.io;

import lombok.Builder;

@Builder
public record GetProductBoundaryInput(Long id) {
}
