package dev.first.core.useCase.createProduct;

import dev.first.core.data.product.ProductGatewayDataBase;
import dev.first.core.factory.useCase.createProducts.CreateProductsBoundaryInputFactory;
import dev.first.core.useCase.createProduct.interactor.CreateProductInteractor;
import dev.first.core.useCase.createProduct.validator.interactor.CreateProductValidatorInteractor;
import dev.first.infrastructure.database.repository.ProductGatewayDataBaseImpl;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

@QuarkusTest
class CreateProductTests {

    private final CreateProductBoundary boundary;

    private final ProductGatewayDataBase dataBase;

    public CreateProductTests() {
        dataBase = Mockito.mock(ProductGatewayDataBaseImpl.class);
        final var validator = new CreateProductValidatorInteractor();
        this.boundary = new CreateProductInteractor(dataBase, validator);
    }

    @Test
    @DisplayName("deve executar com sucesso")
    void shouldCreateProductSuccessfully() {
        final var input = CreateProductsBoundaryInputFactory.getDefault();
        Assertions.assertDoesNotThrow(() -> {boundary.execute(input);});
        Mockito.verify(dataBase).save(Mockito.any());
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
        final var output = Assertions.assertThrows(ConstraintViolationException.class, () -> boundary.execute(null));
        final var errors = output.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();

        Assertions.assertTrue(errors.containsAll(expectedErrosMessage));
    }

    @Test
    @DisplayName("Deve retornar erro de validação quando os campos do input não forem preenchidos")
    void shouldThrowValidationErrorWhenFieldsAreNotFilled() {
        final var input = CreateProductsBoundaryInputFactory.getWithNullValues();
        final var expectedErrosMessage = List.of(
                "o campo description name deve ser preenchido",
                "o campo date deve ser preenchido",
                "o campo quantity name deve ser preenchido",
                "o campo name deve ser preenchido"
        );
        final var output = Assertions.assertThrows(ConstraintViolationException.class, () -> boundary.execute(input));
        final var errors = output.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();

        Assertions.assertTrue(errors.containsAll(expectedErrosMessage));
    }

    @Test
    @DisplayName("Deve retornar erro de validação quando os campos forem preenchidos com string vazia")
    void shouldThrowValidationErrorWhenFieldsAreFilledWithEmptyString() {
        final var input = CreateProductsBoundaryInputFactory.getWithEmptyValues();
        final var expectedErrosMessage = List.of(
                "o campo description name deve ser preenchido",
                "o campo date deve ser preenchido",
                "o campo quantity name deve ser preenchido",
                "o campo name deve ser preenchido"
        );
        final var output = Assertions.assertThrows(ConstraintViolationException.class, () -> boundary.execute(input));
        final var errors = output.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();

        Assertions.assertTrue(errors.containsAll(expectedErrosMessage));
    }

    @Test
    @DisplayName("deve retornar erro de validação quando o campo quantity for menor que zero")
    void shouldReturnValidationErrorWhenQuantityIsLessThanZero() {
        final var input = CreateProductsBoundaryInputFactory.getWithquantityLessThanZero();
        final var expectedErrosMessage = List.of(
                "o campo quantity deve ser maior que zero"
        );
        final var output = Assertions.assertThrows(ConstraintViolationException.class, () -> boundary.execute(input));
        final var errors = output.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();

        Assertions.assertTrue(errors.containsAll(expectedErrosMessage));
    }

    @Test
    @DisplayName("deve retornar erro de validação quando o campo quantity for zero")
    void shouldReturnValidationErrorWhenQuantityIsequalToZero() {
        final var input = CreateProductsBoundaryInputFactory.getWithquantityEqualToZero();
        final var expectedErrosMessage = List.of(
                "o campo quantity deve ser maior que zero"
        );
        final var output = Assertions.assertThrows(ConstraintViolationException.class, () -> boundary.execute(input));
        final var errors = output.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();

        Assertions.assertTrue(errors.containsAll(expectedErrosMessage));
    }

    @Test
    @DisplayName("deve retornar erro de validação quando o campo data não for uma data valida no formato dd-MM-yyyy")
    void shouldReturnValidationErrorWhenDateIsInvalidInFormat() {
        final var input = CreateProductsBoundaryInputFactory.getInvalidDate();
        final var expectedErrosMessage = List.of(
                "padrão da data inválido. Exemplo: 10-10-1999"
        );
        final var output = Assertions.assertThrows(ConstraintViolationException.class, () -> boundary.execute(input));
        final var errors = output.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();

        Assertions.assertTrue(errors.containsAll(expectedErrosMessage));
    }

}