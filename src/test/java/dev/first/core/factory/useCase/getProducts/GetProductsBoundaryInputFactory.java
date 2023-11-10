package dev.first.core.factory.useCase.getProducts;

import dev.first.core.useCase.getProducts.io.GetProductsBoundaryInput;

public final class GetProductsBoundaryInputFactory {

    private GetProductsBoundaryInputFactory() {
    }

    public static GetProductsBoundaryInput getDefault() {
        return GetProductsBoundaryInput.builder()
                .size(2)
                .page(0)
                .build();
    }

    public static GetProductsBoundaryInput getWithoutFields() {
        return GetProductsBoundaryInput.builder().build();
    }
}
