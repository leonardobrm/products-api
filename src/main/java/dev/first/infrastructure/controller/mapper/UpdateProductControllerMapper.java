package dev.first.infrastructure.controller.mapper;

import dev.first.core.useCase.updateProduct.io.UpdateProductBoundaryInput;
import dev.first.infrastructure.controller.request.UpdateProductRequest;
import dev.first.utils.MapperUtils;

public final class UpdateProductControllerMapper {

    private UpdateProductControllerMapper() {
    }

    public static UpdateProductBoundaryInput convertTo(final UpdateProductRequest request) {
        return MapperUtils.map(request, UpdateProductBoundaryInput.class);
    }
}
