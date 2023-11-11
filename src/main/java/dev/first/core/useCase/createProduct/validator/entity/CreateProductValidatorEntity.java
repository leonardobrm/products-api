package dev.first.core.useCase.createProduct.validator.entity;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public class CreateProductValidatorEntity {

    @NotBlank(message = "o campo name deve ser preenchido")
    private String name;

    @NotBlank(message = "o campo description name deve ser preenchido")
    private String description;

    @NotNull(message = "o campo quantity name deve ser preenchido")
    @Min(value = 1, message = "o campo quantity deve ser maior que zero")
    private Integer quantity;

    @NotNull(message = "o campo date deve ser preenchido")
    private String expiry_date;

    public Set<ConstraintViolation<CreateProductValidatorEntity>> validate() {
        final var factory = Validation.buildDefaultValidatorFactory();
        final var validator = factory.getValidator();
        return validator.validate(this);
    }
}
