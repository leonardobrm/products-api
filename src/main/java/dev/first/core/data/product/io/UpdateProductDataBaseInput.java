package dev.first.core.data.product.io;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UpdateProductDataBaseInput(String name, Integer quantity, String description, LocalDateTime expiry_date) {
}
