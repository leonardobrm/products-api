package dev.first.infrastructure.database.repository;

import dev.first.core.data.product.ProductGatewayDataBase;
import dev.first.core.data.product.io.CreateProductDataBaseInput;
import dev.first.infrastructure.database.model.ProductDataBaseModel;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProductGatewayDataBaseMockImpl implements ProductGatewayDataBase {

    static List<ProductDataBaseModel> listOfProducts = new ArrayList<>();

    @Override
    public void create(CreateProductDataBaseInput input) {
        final var dataBaseModel = ProductDataBaseModel.builder()
                .id("TESTETETET")
                .name(input.name())
                .description(input.description())
                .quantity(input.quantity())
                .expiry_date(input.expiry_date())
                .build();
        ProductGatewayDataBaseMockImpl.listOfProducts.add(dataBaseModel);
    }
}
