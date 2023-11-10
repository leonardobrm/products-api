package dev.first.core.factory.useCase.getProduct;

import dev.first.core.useCase.getProduct.io.GetProductBoundaryInput;

public final class GetProductBoundaryInputFactory {

    private GetProductBoundaryInputFactory() {
    }

    public static GetProductBoundaryInput getDefault() {
        return GetProductBoundaryInput.builder().id(2L).build();
    }
}
