package dev.first.core.data.product;

import dev.first.core.data.product.io.*;
import dev.first.infrastructure.database.model.ProductDataBaseModel;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import java.util.Optional;

public interface ProductGatewayDataBase extends PanacheRepositoryBase<ProductDataBaseModel, Long> {

    void save(final CreateProductDataBaseInput input);

    GetProductsDataBaseOutput findAllPaginated(final GetProductsDataBaseInput input);

    GetValidProductsDataBaseOutput findAllValidPaginated(final GetValidProductsDataBaseInput input);

    void delete(Long id);

    Optional<GetProductDataBaseOutput> findbyId(final Long id);

    void update(final UpdateProductDataBaseInput input, final Long id);

}
