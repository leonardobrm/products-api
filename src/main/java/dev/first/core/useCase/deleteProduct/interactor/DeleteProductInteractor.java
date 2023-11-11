package dev.first.core.useCase.deleteProduct.interactor;

import dev.first.core.data.product.ProductGatewayDataBase;
import dev.first.core.useCase.deleteProduct.DeleteProductBoundary;
import dev.first.core.useCase.deleteProduct.io.DeleteProductBoundaryInput;
import dev.first.infrastructure.controller.handler.exception.ProductNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@AllArgsConstructor
@Slf4j
public class DeleteProductInteractor implements DeleteProductBoundary {

    private final ProductGatewayDataBase dataBase;

    @Override
    public void execute(DeleteProductBoundaryInput input) {
        log.info("input={}", input);
        final var productExists = dataBase.findbyId(input.id());
        if (productExists.isEmpty()) {
            throw new ProductNotFoundException("Product not found");
        }
        dataBase.delete(productExists.get().id());
        log.info("output=N/A");
    }
}
