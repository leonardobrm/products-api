package dev.first.infrastructure.controller.response;

import lombok.Builder;

import java.util.List;

@Builder
public record GetProductsResponse(List<GetProductsContentResponse> products, GetProductsPageableResponse pageable) {
}
