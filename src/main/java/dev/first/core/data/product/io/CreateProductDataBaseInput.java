package dev.first.core.data.product.io;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CreateProductDataBaseInput(String name, Integer quantity, String description, LocalDate expiry_date) {
}
