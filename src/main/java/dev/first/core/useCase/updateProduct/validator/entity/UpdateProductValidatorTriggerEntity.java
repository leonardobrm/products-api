package dev.first.core.useCase.updateProduct.validator.entity;

import dev.first.core.useCase.createProduct.io.CreateProductBoundaryInput;
import dev.first.core.useCase.updateProduct.io.UpdateProductBoundaryInput;
import dev.first.core.useCase.updateProduct.validator.exceptions.UpdateProductConstraintViolationException;
import dev.first.utils.MapperUtils;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Objects;

@Slf4j
public final class UpdateProductValidatorTriggerEntity {
    private UpdateProductValidatorTriggerEntity() {
    }

    public static void execute(final UpdateProductBoundaryInput input) {
        log.info("input={}", input);
        final var validator = convertToEntity(input);
        final var violations = new HashSet<>(validator.validate());

        if (Objects.nonNull(input) && Objects.nonNull(input.expiry_date()) && !isValidDate(input.expiry_date())) {
            violations.add(new UpdateProductConstraintViolationException<>("padrão da data inválido. Exemplo: 10-10-1999"));
        }

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        log.info("output=N/A");
    }

    private static UpdateProductValidatorEntity convertToEntity(final UpdateProductBoundaryInput input) {
        final var validateInput = Objects.isNull(input) ? CreateProductBoundaryInput.builder().build() : input;
        return MapperUtils.map(validateInput, UpdateProductValidatorEntity.class);
    }

    private static boolean isValidDate(String dateTimeString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate.parse(dateTimeString, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
