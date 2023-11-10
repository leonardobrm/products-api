package dev.first.core.useCase.getProducts.io;

import lombok.Builder;

@Builder
public record GetProductsPageableBoundaryOutput(Integer pageNumber, Integer pageSize, Long totalElements) {
}
