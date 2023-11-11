package dev.first.core.useCase.updateProduct;

import dev.first.core.data.product.ProductGatewayDataBase;
import dev.first.core.factory.dataBase.GetProductDataBaseOutputFactory;
import dev.first.core.factory.useCase.updateProduct.UpdateProductBoundaryInputFactory;
import dev.first.core.useCase.updateProduct.interactor.UpdateProductInteractor;
import dev.first.core.useCase.updateProduct.validator.interactor.UpdateProductValidatorInteractor;
import dev.first.infrastructure.controller.handler.exception.ProductNotFoundException;
import dev.first.infrastructure.database.repository.ProductGatewayDataBaseImpl;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

@QuarkusTest
class UpdateProductTests {

    private final UpdateProductBoundary boundary;

    private final ProductGatewayDataBase dataBase;

    public UpdateProductTests() {
        dataBase = Mockito.mock(ProductGatewayDataBaseImpl.class);
        final var validator = new UpdateProductValidatorInteractor();
        this.boundary = new UpdateProductInteractor(dataBase, validator);
    }

    @Test
    @DisplayName("deve executar com sucesso")
    void shouldCreateProductSuccessfully() {
        final var input = UpdateProductBoundaryInputFactory.getDefault();
        Mockito.when(dataBase.findbyId(2L)).thenReturn(Optional.of(GetProductDataBaseOutputFactory.getDefault()));
        Assertions.assertDoesNotThrow(() -> {
            boundary.execute(input, 2L);
        });
    }

    @Test
    @DisplayName("deve executar com sucesso")
    void notfound() {
        final var input = UpdateProductBoundaryInputFactory.getDefault();
        Mockito.when(dataBase.findbyId(2L)).thenReturn(Optional.empty());
        final var errorMessage = Assertions.assertThrows(ProductNotFoundException.class, () -> {
            boundary.execute(input, 2L);
        });
        final var expected = "Product not found";
        Assertions.assertEquals(errorMessage.getMessage(), expected);
    }

    @Test
    @DisplayName("Deve retornar erro de validação quando o input for null")
    void shouldThrowValidationErrorWhenInputIsNull() {
        final var expectedErrosMessage = List.of(
                "o campo description name deve ser preenchido",
                "o campo date deve ser preenchido",
                "o campo quantity name deve ser preenchido",
                "o campo name deve ser preenchido"
        );
        final var output = Assertions.assertThrows(ConstraintViolationException.class, () -> boundary.execute(null, null));
        final var errors = output.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();

        Assertions.assertTrue(errors.containsAll(expectedErrosMessage));
    }

    @Test
    @DisplayName("Deve retornar erro de validação quando os campos do input não forem preenchidos")
    void shouldThrowValidationErrorWhenFieldsAreNotFilled() {
        final var input = UpdateProductBoundaryInputFactory.getWithNullValues();
        final var expectedErrosMessage = List.of(
                "o campo description name deve ser preenchido",
                "o campo date deve ser preenchido",
                "o campo quantity name deve ser preenchido",
                "o campo name deve ser preenchido"
        );
        final var output = Assertions.assertThrows(ConstraintViolationException.class, () -> boundary.execute(input, 2L));
        final var errors = output.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();

        Assertions.assertTrue(errors.containsAll(expectedErrosMessage));
    }

    @Test
    @DisplayName("Deve retornar erro de validação quando os campos forem preenchidos com string vazia")
    void shouldThrowValidationErrorWhenFieldsAreFilledWithEmptyString() {
        final var input = UpdateProductBoundaryInputFactory.getWithEmptyValues();
        final var expectedErrosMessage = List.of(
                "o campo description name deve ser preenchido",
                "o campo date deve ser preenchido",
                "o campo quantity name deve ser preenchido",
                "o campo name deve ser preenchido"
        );
        final var output = Assertions.assertThrows(ConstraintViolationException.class, () -> boundary.execute(input, 2L));
        final var errors = output.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();

        Assertions.assertTrue(errors.containsAll(expectedErrosMessage));
    }

    @Test
    @DisplayName("deve retornar erro de validação quando o campo quantity for menor que zero")
    void shouldReturnValidationErrorWhenQuantityIsLessThanZero() {
        final var input = UpdateProductBoundaryInputFactory.getWithquantityLessThanZero();
        final var expectedErrosMessage = List.of(
                "o campo quantity deve ser maior que zero"
        );
        final var output = Assertions.assertThrows(ConstraintViolationException.class, () -> boundary.execute(input, 2L));
        final var errors = output.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();

        Assertions.assertTrue(errors.containsAll(expectedErrosMessage));
    }

    @Test
    @DisplayName("deve retornar erro de validação quando o campo quantity for zero")
    void shouldReturnValidationErrorWhenQuantityIsequalToZero() {
        final var input = UpdateProductBoundaryInputFactory.getWithquantityEqualToZero();
        final var expectedErrosMessage = List.of(
                "o campo quantity deve ser maior que zero"
        );
        final var output = Assertions.assertThrows(ConstraintViolationException.class, () -> boundary.execute(input, 2L));
        final var errors = output.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();

        Assertions.assertTrue(errors.containsAll(expectedErrosMessage));
    }

    @Test
    @DisplayName("deve retornar erro de validação quando o campo data não for uma data valida no formato dd-MM-yyyy")
    void shouldReturnValidationErrorWhenDateIsInvalidInFormat() {
        final var input = UpdateProductBoundaryInputFactory.getInvalidDate();
        final var expectedErrosMessage = List.of(
                "padrão da data inválido. Exemplo: 10-10-1999"
        );
        final var output = Assertions.assertThrows(ConstraintViolationException.class, () -> boundary.execute(input, 2L));
        final var errors = output.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();

        Assertions.assertTrue(errors.containsAll(expectedErrosMessage));
    }
}
