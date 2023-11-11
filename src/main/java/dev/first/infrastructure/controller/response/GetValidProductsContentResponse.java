package dev.first.infrastructure.controller.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
public record GetValidProductsContentResponse(Long id, String name, Integer quantity, String description,
                                              LocalDateTime expiry_date) {
}
