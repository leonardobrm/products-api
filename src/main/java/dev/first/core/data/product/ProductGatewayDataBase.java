package dev.first.core.data.product;

import dev.first.core.data.product.io.CreateProductDataBaseInput;
import dev.first.infrastructure.database.model.ProductDataBaseModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface ProductGatewayDataBase extends PanacheRepository<ProductDataBaseModel> {

    void save(final CreateProductDataBaseInput input);
}
