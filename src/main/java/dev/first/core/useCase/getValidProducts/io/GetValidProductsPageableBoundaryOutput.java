package dev.first.core.useCase.getValidProducts.io;

import lombok.Builder;

@Builder(toBuilder = true)
public record GetValidProductsPageableBoundaryOutput(Integer pageNumber, Integer pageSize, Long totalElements) {
}
