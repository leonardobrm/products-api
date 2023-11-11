package dev.first.core.infrastructure.factory.controller.response;

import dev.first.infrastructure.controller.response.GetProductsContentResponse;
import dev.first.infrastructure.controller.response.GetProductsPageableResponse;
import dev.first.infrastructure.controller.response.GetProductsResponse;

import java.time.LocalDateTime;
import java.util.List;

public final class GetProductsResponseFactory {

    private GetProductsResponseFactory() {
    }

    public static GetProductsResponse getDefault() {
        return getProductsResponseDefault();
    }


    private static GetProductsResponse getProductsResponseDefault() {
        return GetProductsResponse.builder()
                .products(List.of(getProductsContentResponseDefault(),
                        getProductsContentResponseDefault(),
                        getProductsContentResponseDefault(),
                        getProductsContentResponseDefault(),
                        getProductsContentResponseDefault()))
                .pageable(getProductsPageableResponseDefault())
                .build();
    }

    private static GetProductsContentResponse getProductsContentResponseDefault() {
        return GetProductsContentResponse.builder()
                .id(1L)
                .description("produto teste")
                .name("produto teste")
                .expiry_date(LocalDateTime.parse("2023-11-09T00:00"))
                .quantity(2)
                .build();
    }

    private static GetProductsPageableResponse getProductsPageableResponseDefault() {
        return GetProductsPageableResponse.builder()
                .pageSize(5)
                .pageNumber(0)
                .totalElements(5L)
                .build();
    }
}
