package dev.first.core.useCase.getProducts.io;

import lombok.Builder;

import java.util.List;

@Builder
public record GetProductsBoundaryOutput(List<GetProductsContentBoundaryOutput> products,
                                        GetProductsPageableBoundaryOutput pageable) {
}
