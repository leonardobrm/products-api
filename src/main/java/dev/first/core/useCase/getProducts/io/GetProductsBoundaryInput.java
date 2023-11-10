package dev.first.core.useCase.getProducts.io;

import lombok.Builder;

@Builder
public record GetProductsBoundaryInput(Integer page, Integer size) {
}
