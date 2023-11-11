package dev.first.infrastructure.controller.mapper;

import dev.first.core.useCase.createProduct.io.CreateProductBoundaryInput;
import dev.first.infrastructure.controller.request.CreateProductRequest;
import dev.first.utils.MapperUtils;

public final class CreateProductControllerMapper {

    private CreateProductControllerMapper() {
    }

    public static CreateProductBoundaryInput convertTo(final CreateProductRequest request) {
        return MapperUtils.map(request, CreateProductBoundaryInput.class);
    }

}
