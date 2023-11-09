package dev.first.infrastructure.database.repository;

import dev.first.core.data.product.ProductGatewayDataBase;
import dev.first.core.data.product.io.CreateProductDataBaseInput;
import dev.first.infrastructure.database.model.ProductDataBaseModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProductGatewayDataBaseImpl implements ProductGatewayDataBase {

    @Override
    @Transactional
    public void save(CreateProductDataBaseInput input) {
        final var dataBaseModel = ProductDataBaseModel.builder()
                .name(input.name())
                .description(input.description())
                .quantity(input.quantity())
                .expiry_date(input.expiry_date())
                .build();
        persist(dataBaseModel);
    }
}
