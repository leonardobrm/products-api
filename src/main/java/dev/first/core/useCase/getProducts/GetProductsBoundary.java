package dev.first.core.useCase.getProducts;

import dev.first.core.useCase.getProducts.io.GetProductsBoundaryInput;
import dev.first.core.useCase.getProducts.io.GetProductsBoundaryOutput;

public interface GetProductsBoundary {

    GetProductsBoundaryOutput execute(final GetProductsBoundaryInput input);
}
