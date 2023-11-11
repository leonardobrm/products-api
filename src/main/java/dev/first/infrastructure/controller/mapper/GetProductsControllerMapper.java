package dev.first.infrastructure.controller.mapper;

import dev.first.core.useCase.getProducts.io.GetProductsBoundaryOutput;
import dev.first.infrastructure.controller.response.GetProductsResponse;
import dev.first.utils.MapperUtils;

public final class GetProductsControllerMapper {

    private GetProductsControllerMapper() {
    }

    public static GetProductsResponse convertTo(final GetProductsBoundaryOutput request) {
        return MapperUtils.map(request, GetProductsResponse.class);
    }
}
