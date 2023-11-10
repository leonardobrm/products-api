package dev.first.infrastructure.controller.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record GetProductsContentResponse(Long id, String name, Integer quantity, String description,
                                         LocalDateTime expiry_date) {
}
