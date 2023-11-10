package dev.first.core.data.product.io;

import java.time.LocalDateTime;

public record GetProductsContentDataBaseOutput(Long id, String name, Integer quantity, String description,
                                               LocalDateTime expiry_date) {
}
