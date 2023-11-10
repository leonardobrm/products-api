package dev.first.core.data.product;

import dev.first.core.data.product.io.CreateProductDataBaseInput;
import dev.first.core.data.product.io.GetProductsDataBaseInput;
import dev.first.core.data.product.io.GetProductsDataBaseOutput;
import dev.first.infrastructure.database.model.ProductDataBaseModel;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

public interface ProductGatewayDataBase extends PanacheRepositoryBase<ProductDataBaseModel, Long> {

    void save(final CreateProductDataBaseInput input);

    GetProductsDataBaseOutput getAllPaginated(final GetProductsDataBaseInput input);
}
