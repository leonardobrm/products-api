package dev.first.infrastructure.controller.response;

import java.util.List;

public record GetValidProductsResponse(List<GetValidProductsContentResponse> products, GetValidProductsPageableResponse pageable) {
}
