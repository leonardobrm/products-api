package dev.first.core.useCase.getProduct;

import dev.first.core.useCase.getProduct.io.GetProductBoundaryInput;
import dev.first.core.useCase.getProduct.io.GetProductBoundaryOutput;

public interface GetProductBoundary {

    GetProductBoundaryOutput execute(final GetProductBoundaryInput input);
}
