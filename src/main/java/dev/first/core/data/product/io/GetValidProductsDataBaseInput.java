package dev.first.core.data.product.io;

import lombok.Builder;

@Builder
public record GetValidProductsDataBaseInput(Integer page, Integer size) {
}
