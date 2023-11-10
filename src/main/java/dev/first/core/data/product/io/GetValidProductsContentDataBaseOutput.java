package dev.first.core.data.product.io;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
public record GetValidProductsContentDataBaseOutput(Long id, String name, Integer quantity, String description,
                                                    LocalDateTime expiry_date) {
}
