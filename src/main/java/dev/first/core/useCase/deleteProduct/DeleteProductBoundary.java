package dev.first.core.useCase.deleteProduct;

import dev.first.core.useCase.deleteProduct.io.DeleteProductBoundaryInput;

public interface DeleteProductBoundary {

    void execute(final DeleteProductBoundaryInput input);
}
