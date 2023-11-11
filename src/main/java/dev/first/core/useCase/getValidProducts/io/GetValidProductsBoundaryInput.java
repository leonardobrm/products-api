package dev.first.core.useCase.getValidProducts.io;

import lombok.Builder;

@Builder
public record GetValidProductsBoundaryInput(Integer page, Integer size) {
}
