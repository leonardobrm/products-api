package dev.first.core.useCase.createProduct.validator;

import dev.first.core.useCase.createProduct.io.CreateProductBoundaryInput;

public interface CreateProductValidatorBoundary {

    void validate(final CreateProductBoundaryInput input);
}
