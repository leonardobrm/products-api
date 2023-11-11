package dev.first.core.factory.useCase.deleteProduct;

import dev.first.core.useCase.deleteProduct.io.DeleteProductBoundaryInput;

public final class DeleteProductBoundaryInputFactory {

    private DeleteProductBoundaryInputFactory() {
    }

    public static DeleteProductBoundaryInput getDefault() {
        return DeleteProductBoundaryInput.builder().id(2L).build();
    }
}
