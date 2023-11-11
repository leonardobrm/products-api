package dev.first.core.useCase.deleteProduct.io;

import lombok.Builder;

@Builder
public record DeleteProductBoundaryInput(Long id) {
}
