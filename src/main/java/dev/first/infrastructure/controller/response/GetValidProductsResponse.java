package dev.first.infrastructure.controller.response;

import lombok.Builder;

import java.util.List;

@Builder
public record GetValidProductsResponse(List<GetValidProductsContentResponse> products, GetValidProductsPageableResponse pageable) {
}
