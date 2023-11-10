package dev.first.core.useCase.getValidProducts.io;

import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public record GetValidProductsBoundaryOutput(List<GetValidProductsContentBoundaryOutput> products,
                                             GetValidProductsPageableBoundaryOutput pageable) {
}
