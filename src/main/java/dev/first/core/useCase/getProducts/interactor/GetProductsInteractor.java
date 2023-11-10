package dev.first.core.useCase.getProducts.interactor;

import dev.first.core.data.product.ProductGatewayDataBase;
import dev.first.core.useCase.getProducts.GetProductsBoundary;
import dev.first.core.useCase.getProducts.entity.GetProductsEntity;
import dev.first.core.useCase.getProducts.io.GetProductsBoundaryInput;
import dev.first.core.useCase.getProducts.io.GetProductsBoundaryOutput;
import dev.first.utils.MapperUtils;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@AllArgsConstructor
@Slf4j
public class GetProductsInteractor implements GetProductsBoundary {

    private final ProductGatewayDataBase dataBase;

    @Override
    public GetProductsBoundaryOutput execute(final GetProductsBoundaryInput input) {
        log.info("input={}", input);
        final var dataBaseInput = GetProductsEntity.createDataBaseInput(input);
        final var findProducts = dataBase.findAllPaginated(dataBaseInput);
        final var output = MapperUtils.map(findProducts, GetProductsBoundaryOutput.class);
        log.info("output={}", output);
        return output;

    }
}
