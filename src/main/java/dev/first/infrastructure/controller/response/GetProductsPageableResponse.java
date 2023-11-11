package dev.first.infrastructure.controller.response;

public record GetProductsPageableResponse(Integer pageNumber, Integer pageSize, Long totalElements) {
}
