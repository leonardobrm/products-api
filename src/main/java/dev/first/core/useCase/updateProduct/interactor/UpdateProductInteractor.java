package dev.first.core.useCase.updateProduct.interactor;

import dev.first.core.data.product.ProductGatewayDataBase;
import dev.first.core.useCase.updateProduct.UpdateProductBoundary;
import dev.first.core.useCase.updateProduct.entity.UpdateProductEntity;
import dev.first.core.useCase.updateProduct.io.UpdateProductBoundaryInput;
import dev.first.core.useCase.updateProduct.validator.UpdateProductValidatorBoundary;
import dev.first.infrastructure.controller.handler.exception.ProductNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@AllArgsConstructor
@Slf4j
public class UpdateProductInteractor implements UpdateProductBoundary {

    private final ProductGatewayDataBase dataBase;

    private final UpdateProductValidatorBoundary validator;

    @Override
    @Transactional
    public void execute(UpdateProductBoundaryInput input, Long id) {
        validator.validate(input);

        final var product = dataBase.findbyId(id);

        if (product.isEmpty()) {
            throw new ProductNotFoundException("Product not found");
        }
        final var dataBaseInput = UpdateProductEntity.createDataBaseInput(input);
        dataBase.update(dataBaseInput, id);
    }
}
