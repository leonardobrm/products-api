package dev.first.core.data.product.io;

import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public record GetValidProductsDataBaseOutput(List<GetValidProductsContentDataBaseOutput> products,
                                             GetValidProductsPageableDataBaseOutput pageable) {
}
