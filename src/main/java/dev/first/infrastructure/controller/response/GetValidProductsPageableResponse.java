package dev.first.infrastructure.controller.response;

import lombok.Builder;

@Builder
public record GetValidProductsPageableResponse(Integer pageNumber, Integer pageSize, Long totalElements) {
}
