package dev.first.core.useCase.getValidProducts.interactor;

import dev.first.core.data.product.ProductGatewayDataBase;
import dev.first.core.useCase.getValidProducts.GetValidProductsBoundary;
import dev.first.core.useCase.getValidProducts.entity.GetValidProductsEntity;
import dev.first.core.useCase.getValidProducts.io.GetValidProductsBoundaryInput;
import dev.first.core.useCase.getValidProducts.io.GetValidProductsBoundaryOutput;
import dev.first.utils.MapperUtils;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@AllArgsConstructor
@Slf4j
public class GetValidProductsInteractor implements GetValidProductsBoundary {

    private final ProductGatewayDataBase dataBase;

    @Override
    public GetValidProductsBoundaryOutput execute(final GetValidProductsBoundaryInput input) {
        log.info("input={}", input);
        final var dataBaseInput = GetValidProductsEntity.createDataBaseInput(input);
        final var findProducts = dataBase.findAllValidPaginated(dataBaseInput);
        final var output = MapperUtils.map(findProducts, GetValidProductsBoundaryOutput.class);
        log.info("output={}", output);
        return output;

    }
}
