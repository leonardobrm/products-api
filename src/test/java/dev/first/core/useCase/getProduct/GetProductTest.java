package dev.first.core.useCase.getProduct;

import dev.first.core.data.product.ProductGatewayDataBase;
import dev.first.core.factory.dataBase.GetProductDataBaseOutputFactory;
import dev.first.core.factory.useCase.getProduct.GetProductBoundaryInputFactory;
import dev.first.core.factory.useCase.getProduct.GetProductBoundaryOutputFactory;
import dev.first.core.useCase.getProduct.interactor.GetProductInteractor;
import dev.first.infrastructure.controller.handler.exception.ProductNotFoundException;
import dev.first.infrastructure.database.repository.ProductGatewayDataBaseImpl;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

@QuarkusTest
class GetProductTest {

    private final GetProductBoundary boundary;

    private final ProductGatewayDataBase dataBase;

    public GetProductTest() {
        dataBase = Mockito.mock(ProductGatewayDataBaseImpl.class);
        this.boundary = new GetProductInteractor(dataBase);
    }

    @Test
    @DisplayName("deve executar com sucesso sem passar nenhum parametro")
    void shouldLoadDataSuccessfullyWithoutParameters() {
        final var input = GetProductBoundaryInputFactory.getDefault();
        Mockito.when(dataBase.findbyId(Mockito.any())).thenReturn(Optional.of(GetProductDataBaseOutputFactory.getDefault()));
        final var output = boundary.execute(input);
        final var expected = GetProductBoundaryOutputFactory.getDefault();
        Assertions.assertEquals(output, expected);
    }

    @Test
    @DisplayName("deve executar com sucesso quando não for encontrado valores")
    void shouldReturnEmptyListWhenNoValuesFound() {
        final var input = GetProductBoundaryInputFactory.getDefault();
        Mockito.when(dataBase.findbyId(Mockito.any())).thenReturn(Optional.empty());
        final var errorMessage = Assertions.assertThrows(ProductNotFoundException.class, () -> boundary.execute(input));
        final var expected = "Product not found";
        Assertions.assertEquals(errorMessage.getMessage(), expected);
    }
}
