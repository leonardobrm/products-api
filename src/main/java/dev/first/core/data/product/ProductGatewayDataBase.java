package dev.first.core.data.product;

import dev.first.core.data.product.io.CreateProductDataBaseInput;

public interface ProductGatewayDataBase {

    void create(final CreateProductDataBaseInput input);
}
