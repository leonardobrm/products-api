package dev.first.core.useCase.createProduct;

import dev.first.core.useCase.createProduct.io.CreateProductBoundaryInput;

public interface CreateProductBoundary {

    void execute(final CreateProductBoundaryInput input);
}
