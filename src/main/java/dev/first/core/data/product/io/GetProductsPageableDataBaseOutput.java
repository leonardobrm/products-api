package dev.first.core.data.product.io;

import lombok.Builder;

@Builder(toBuilder = true)
public record GetProductsPageableDataBaseOutput (Integer pageNumber, Integer pageSize, Long  totalElements) {

}
