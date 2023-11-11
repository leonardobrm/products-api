package dev.first.core.useCase.updateProduct;

import dev.first.core.useCase.updateProduct.io.UpdateProductBoundaryInput;

public interface UpdateProductBoundary {

    void execute(final UpdateProductBoundaryInput input, final Long id);
}
