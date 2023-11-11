package dev.first.infrastructure.controller.mapper;

import dev.first.core.useCase.getValidProducts.io.GetValidProductsBoundaryOutput;
import dev.first.infrastructure.controller.response.GetValidProductsResponse;
import dev.first.utils.MapperUtils;

public final class GetValidProductsControllerMapper {

    private GetValidProductsControllerMapper() {

    }

    public static GetValidProductsResponse convertTo(final GetValidProductsBoundaryOutput request) {
        return MapperUtils.map(request, GetValidProductsResponse.class);
    }
}
