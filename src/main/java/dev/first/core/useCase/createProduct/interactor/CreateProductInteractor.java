package dev.first.core.useCase.createProduct.interactor;

import dev.first.core.data.product.ProductGatewayDataBase;
import dev.first.core.useCase.createProduct.CreateProductBoundary;
import dev.first.core.useCase.createProduct.entity.CreateProductEntity;
import dev.first.core.useCase.createProduct.io.CreateProductBoundaryInput;
import dev.first.core.useCase.createProduct.validator.CreateProductValidatorBoundary;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
@AllArgsConstructor
public class CreateProductInteractor implements CreateProductBoundary {

    private final ProductGatewayDataBase dataBase;

    private final CreateProductValidatorBoundary validator;

    @Override
    public void execute(CreateProductBoundaryInput input) {
        log.debug("input={}", input);
        validator.validate(input);
        final var dataBaseInput = CreateProductEntity.createDataBaseInput(input);
        dataBase.create(dataBaseInput);
        log.debug("output=N/A");
    }
}
