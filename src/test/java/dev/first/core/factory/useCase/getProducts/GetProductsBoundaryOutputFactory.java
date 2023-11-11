package dev.first.core.factory.useCase.getProducts;

import dev.first.core.useCase.getProducts.io.GetProductsBoundaryOutput;
import dev.first.core.useCase.getProducts.io.GetProductsContentBoundaryOutput;
import dev.first.core.useCase.getProducts.io.GetProductsPageableBoundaryOutput;

import java.time.LocalDateTime;
import java.util.List;

public final class GetProductsBoundaryOutputFactory {

    private GetProductsBoundaryOutputFactory() {
    }

    public static GetProductsBoundaryOutput getDefault() {
        return getGetProductsBoundaryOutputDefault();
    }

    public static GetProductsBoundaryOutput getWithoutProducts() {
        return getGetProductsBoundaryOutputDefault().toBuilder()
                .products(List.of())
                .pageable(getGetProductsPageableBoundaryOutputDefault().toBuilder()
                        .pageSize(2)
                        .pageNumber(0)
                        .totalElements(5L)
                        .build())
                .build();
    }

    public static GetProductsBoundaryOutput getWithOneProduct() {
        return getGetProductsBoundaryOutputDefault().toBuilder()
                .products(List.of(getGetProductsContentBoundaryOutputDefault()))
                .pageable(getGetProductsPageableBoundaryOutputDefault().toBuilder()
                        .pageSize(2)
                        .pageNumber(0)
                        .totalElements(1L)
                        .build())
                .build();
    }

    private static GetProductsContentBoundaryOutput getGetProductsContentBoundaryOutputDefault() {
        return GetProductsContentBoundaryOutput.builder()
                .id(1L)
                .description("produto teste")
                .name("produto teste")
                .expiry_date(LocalDateTime.parse("2023-11-09T00:00"))
                .quantity(2)
                .build();
    }

    private static GetProductsPageableBoundaryOutput getGetProductsPageableBoundaryOutputDefault() {
        return GetProductsPageableBoundaryOutput.builder()
                .pageSize(5)
                .pageNumber(0)
                .totalElements(5L)
                .build();
    }

    private static GetProductsBoundaryOutput getGetProductsBoundaryOutputDefault() {
        return GetProductsBoundaryOutput.builder()
                .products(List.of(getGetProductsContentBoundaryOutputDefault(),
                        getGetProductsContentBoundaryOutputDefault(),
                        getGetProductsContentBoundaryOutputDefault(),
                        getGetProductsContentBoundaryOutputDefault(),
                        getGetProductsContentBoundaryOutputDefault()))
                .pageable(getGetProductsPageableBoundaryOutputDefault())
                .build();
    }
}
