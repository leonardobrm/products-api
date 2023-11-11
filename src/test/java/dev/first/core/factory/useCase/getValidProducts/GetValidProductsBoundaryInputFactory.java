package dev.first.core.factory.useCase.getValidProducts;

import dev.first.core.useCase.getValidProducts.io.GetValidProductsBoundaryInput;

public final class GetValidProductsBoundaryInputFactory {

    private GetValidProductsBoundaryInputFactory() {
    }

    public static GetValidProductsBoundaryInput getDefault() {
        return GetValidProductsBoundaryInput.builder()
                .size(2)
                .page(0)
                .build();
    }

    public static GetValidProductsBoundaryInput getWithoutFields() {
        return GetValidProductsBoundaryInput.builder().build();
    }
}
