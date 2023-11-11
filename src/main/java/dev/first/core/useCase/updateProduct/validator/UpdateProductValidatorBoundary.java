package dev.first.core.useCase.updateProduct.validator;

import dev.first.core.useCase.updateProduct.io.UpdateProductBoundaryInput;

public interface UpdateProductValidatorBoundary {

    void validate(final UpdateProductBoundaryInput input);

}
