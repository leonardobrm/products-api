package dev.first.core.useCase.getProduct.interactor;

import dev.first.core.data.product.ProductGatewayDataBase;
import dev.first.core.useCase.getProduct.GetProductBoundary;
import dev.first.core.useCase.getProduct.io.GetProductBoundaryInput;
import dev.first.core.useCase.getProduct.io.GetProductBoundaryOutput;
import dev.first.infrastructure.controller.handler.exception.ProductNotFoundException;
import dev.first.utils.MapperUtils;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@AllArgsConstructor
@Slf4j
public class GetProductInteractor implements GetProductBoundary {

    private final ProductGatewayDataBase dataBase;

    @Override
    public GetProductBoundaryOutput execute(GetProductBoundaryInput input) {
        log.info("input={}", input);
        final var productExists = dataBase.findbyId(input.id());
        if (productExists.isEmpty()) {
            throw new ProductNotFoundException("Product not found");
        }
        final var output = MapperUtils.map(productExists.get(), GetProductBoundaryOutput.class);
        log.info("output={}", output);
        return output;
    }
}
