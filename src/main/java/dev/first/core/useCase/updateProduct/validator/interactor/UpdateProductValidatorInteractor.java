package dev.first.core.useCase.updateProduct.validator.interactor;

import dev.first.core.useCase.updateProduct.io.UpdateProductBoundaryInput;
import dev.first.core.useCase.updateProduct.validator.UpdateProductValidatorBoundary;
import dev.first.core.useCase.updateProduct.validator.entity.UpdateProductValidatorTriggerEntity;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class UpdateProductValidatorInteractor implements UpdateProductValidatorBoundary {
    @Override
    public void validate(UpdateProductBoundaryInput input) {
        log.info("input={}", input);
        UpdateProductValidatorTriggerEntity.execute(input);
        log.info("output=N/A");
    }
}
