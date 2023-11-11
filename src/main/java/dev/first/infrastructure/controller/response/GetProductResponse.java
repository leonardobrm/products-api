package dev.first.infrastructure.controller.response;

import java.time.LocalDateTime;

public record GetProductResponse(Long id, String name, Integer quantity, String description,
                                 LocalDateTime expiry_date) {
}
