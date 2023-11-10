package dev.first.core.useCase.getValidProducts;

import dev.first.core.useCase.getValidProducts.io.GetValidProductsBoundaryInput;
import dev.first.core.useCase.getValidProducts.io.GetValidProductsBoundaryOutput;

public interface GetValidProductsBoundary {

    GetValidProductsBoundaryOutput execute(final GetValidProductsBoundaryInput input);
}
