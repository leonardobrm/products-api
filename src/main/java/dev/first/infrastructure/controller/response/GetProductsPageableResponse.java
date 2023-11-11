package dev.first.infrastructure.controller.response;

import lombok.Builder;

@Builder
public record GetProductsPageableResponse(Integer pageNumber, Integer pageSize, Long totalElements) {
}
