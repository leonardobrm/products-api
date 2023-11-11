package dev.first.core.data.product.io;

import lombok.Builder;

@Builder
public record GetProductsDataBaseInput(Integer page, Integer size) {
}
