package dev.first.core.data.product.io;

import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public record GetProductsDataBaseOutput(List<GetProductsContentDataBaseOutput> products, GetProductsPageableDataBaseOutput pageable) {
}
