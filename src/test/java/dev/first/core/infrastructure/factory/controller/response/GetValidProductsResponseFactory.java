package dev.first.core.infrastructure.factory.controller.response;

import dev.first.infrastructure.controller.response.GetValidProductsContentResponse;
import dev.first.infrastructure.controller.response.GetValidProductsPageableResponse;
import dev.first.infrastructure.controller.response.GetValidProductsResponse;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public final class GetValidProductsResponseFactory {

    private GetValidProductsResponseFactory() {
    }

    public static GetValidProductsResponse getDefault() {
        return getValidProductsResponseDefault();
    }


    private static GetValidProductsContentResponse getValidProductsContentResponseOutputDefault() {
        return GetValidProductsContentResponse.builder()
                .id(1L)
                .description("produto teste")
                .name("produto teste")
                .expiry_date(LocalDateTime.parse("2023-11-09T00:00"))
                .quantity(2)
                .build();
    }

    private static GetValidProductsPageableResponse GetValidProductsPageableResponseDefault() {
        return GetValidProductsPageableResponse.builder()
                .pageSize(5)
                .pageNumber(0)
                .totalElements(5L)
                .build();
    }

    private static GetValidProductsResponse getValidProductsResponseDefault() {
        return GetValidProductsResponse.builder()
                .products(List.of(
                        getValidProductsContentResponseOutputDefault(),
                        getValidProductsContentResponseOutputDefault(),
                        getValidProductsContentResponseOutputDefault(),
                        getValidProductsContentResponseOutputDefault(),
                        getValidProductsContentResponseOutputDefault().toBuilder()
                                .id(1L)
                                .description("produto teste")
                                .name("produto teste")
                                .expiry_date(LocalDateTime.now().plusDays(1).with(LocalTime.MIDNIGHT))
                                .quantity(2)
                                .build(),
                        getValidProductsContentResponseOutputDefault()))
                .pageable(GetValidProductsPageableResponseDefault())
                .build();
    }
}
