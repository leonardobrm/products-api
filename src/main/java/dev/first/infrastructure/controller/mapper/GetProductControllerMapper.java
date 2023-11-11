package dev.first.infrastructure.controller.mapper;

import dev.first.core.useCase.getProduct.io.GetProductBoundaryOutput;
import dev.first.infrastructure.controller.response.GetProductResponse;
import dev.first.utils.MapperUtils;

public final class GetProductControllerMapper {

    private GetProductControllerMapper() {
    }

    public static GetProductResponse convertTo(final GetProductBoundaryOutput request) {
        return MapperUtils.map(request, GetProductResponse.class);
    }
}
