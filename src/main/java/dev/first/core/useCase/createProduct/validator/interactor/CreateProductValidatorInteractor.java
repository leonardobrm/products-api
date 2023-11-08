package dev.first.core.useCase.createProduct.validator.interactor;

import dev.first.core.useCase.createProduct.io.CreateProductBoundaryInput;
import dev.first.core.useCase.createProduct.validator.CreateProductValidatorBoundary;
import dev.first.core.useCase.createProduct.validator.entity.CreateProductValidatorTriggerEntity;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class CreateProductValidatorInteractor implements CreateProductValidatorBoundary {

    @Override
    public void validate(CreateProductBoundaryInput input) {
        log.debug("input={}", input);
        CreateProductValidatorTriggerEntity.execute(input);
        log.debug("output=N/A");
    }
}
