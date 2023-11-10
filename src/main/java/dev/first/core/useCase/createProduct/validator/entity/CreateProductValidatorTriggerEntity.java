package dev.first.core.useCase.createProduct.validator.entity;

import dev.first.core.useCase.createProduct.io.CreateProductBoundaryInput;
import dev.first.core.useCase.createProduct.validator.exceptions.CreateProductConstraintViolationException;
import dev.first.utils.MapperUtils;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Objects;

@Slf4j
public final class CreateProductValidatorTriggerEntity {

    private CreateProductValidatorTriggerEntity() {
    }

    public static void execute(final CreateProductBoundaryInput input) {
        log.debug("input={}", input);
        final var validator = convertToEntity(input);
        final var violations = new HashSet<>(validator.validate());

        if (Objects.nonNull(input) && Objects.nonNull(input.expiry_date()) && !isValidDate(input.expiry_date())) {
            violations.add(new CreateProductConstraintViolationException<>("padrão da data inválido. Exemplo: 10-10-1999"));
        }

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        log.debug("output=N/A");
    }

    private static CreateProductValidatorEntity convertToEntity(final CreateProductBoundaryInput input) {
        final var validateInput = Objects.isNull(input) ? CreateProductBoundaryInput.builder().build() : input;
        return MapperUtils.map(validateInput, CreateProductValidatorEntity.class);
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
