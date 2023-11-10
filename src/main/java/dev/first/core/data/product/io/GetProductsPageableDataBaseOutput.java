package dev.first.core.data.product.io;

import lombok.Builder;

@Builder
public record GetProductsPageableDataBaseOutput (Integer pageNumber, Integer pageSize, Long  totalElements) {

}
