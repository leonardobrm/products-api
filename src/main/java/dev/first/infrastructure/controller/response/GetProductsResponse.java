package dev.first.infrastructure.controller.response;

import java.util.List;

public record GetProductsResponse(List<GetProductsContentResponse> products, GetProductsPageableResponse pageable) {
}
