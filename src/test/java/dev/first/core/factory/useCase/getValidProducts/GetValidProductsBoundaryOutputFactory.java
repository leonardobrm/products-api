package dev.first.core.factory.useCase.getValidProducts;

import dev.first.core.useCase.getValidProducts.io.GetValidProductsBoundaryOutput;
import dev.first.core.useCase.getValidProducts.io.GetValidProductsContentBoundaryOutput;
import dev.first.core.useCase.getValidProducts.io.GetValidProductsPageableBoundaryOutput;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public final class GetValidProductsBoundaryOutputFactory {

    private GetValidProductsBoundaryOutputFactory() {
    }

    public static GetValidProductsBoundaryOutput getDefault() {
        return getValidGetProductsBoundaryOutputDefault();
    }

    public static GetValidProductsBoundaryOutput getWithoutProducts() {
        return getDefault().toBuilder()
                .products(List.of())
                .pageable(getValidProductsPageableBoundaryOutputDefault().toBuilder()
                        .pageSize(2)
                        .pageNumber(0)
                        .totalElements(5L)
                        .build())
                .build();
    }

    public static GetValidProductsBoundaryOutput getWithValidProducts() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        final var date = LocalDate.parse("09-11-2023", formatter).atStartOfDay();

        return GetValidProductsBoundaryOutput.builder()
                .products(List.of(
                        getValidProductsContentBoundaryOutputDefault().toBuilder()
                                .id(1L)
                                .description("produto teste")
                                .name("produto teste")
                                .expiry_date(date.plusDays(1))
                                .quantity(2)
                                .build()
                ))
                .pageable(getValidProductsPageableBoundaryOutputDefault().toBuilder()
                        .pageSize(2)
                        .pageNumber(0)
                        .totalElements(1L)
                        .build())
                .build();
    }

    public static GetValidProductsBoundaryOutput getWithOneProduct() {
        return getValidGetProductsBoundaryOutputDefault().toBuilder()
                .products(List.of(getValidProductsContentBoundaryOutputDefault()))
                .pageable(getValidProductsPageableBoundaryOutputDefault().toBuilder()
                        .pageSize(2)
                        .pageNumber(0)
                        .totalElements(1L)
                        .build())
                .build();
    }

    private static GetValidProductsContentBoundaryOutput getValidProductsContentBoundaryOutputDefault() {
        return GetValidProductsContentBoundaryOutput.builder()
                .id(1L)
                .description("produto teste")
                .name("produto teste")
                .expiry_date(LocalDateTime.parse("2023-11-09T00:00"))
                .quantity(2)
                .build();
    }

    private static GetValidProductsPageableBoundaryOutput getValidProductsPageableBoundaryOutputDefault() {
        return GetValidProductsPageableBoundaryOutput.builder()
                .pageSize(5)
                .pageNumber(0)
                .totalElements(5L)
                .build();
    }

    private static GetValidProductsBoundaryOutput getValidGetProductsBoundaryOutputDefault() {
        return GetValidProductsBoundaryOutput.builder()
                .products(List.of(getValidProductsContentBoundaryOutputDefault(),
                        getValidProductsContentBoundaryOutputDefault(),
                        getValidProductsContentBoundaryOutputDefault(),
                        getValidProductsContentBoundaryOutputDefault(),
                        getValidProductsContentBoundaryOutputDefault().toBuilder()
                                .id(1L)
                                .description("produto teste")
                                .name("produto teste")
                                .expiry_date(LocalDateTime.now().plusDays(1))
                                .quantity(2)
                                .build(),
                        getValidProductsContentBoundaryOutputDefault()))
                .pageable(getValidProductsPageableBoundaryOutputDefault())
                .build();
    }
}
