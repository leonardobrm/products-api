package dev.first.infrastructure.controller.response;

public record GetValidProductsPageableResponse(Integer pageNumber, Integer pageSize, Long totalElements) {
}
