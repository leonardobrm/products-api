package dev.first.core.useCase.getProducts.io;

import lombok.Builder;

@Builder(toBuilder = true)
public record GetProductsPageableBoundaryOutput(Integer pageNumber, Integer pageSize, Long totalElements) {
}
