package dev.first.core.useCase.deleteProduct;

import dev.first.core.data.product.ProductGatewayDataBase;
import dev.first.core.factory.dataBase.GetProductDataBaseOutputFactory;
import dev.first.core.factory.useCase.deleteProduct.DeleteProductBoundaryInputFactory;
import dev.first.core.useCase.deleteProduct.interactor.DeleteProductInteractor;
import dev.first.infrastructure.controller.handler.exception.ProductNotFoundException;
import dev.first.infrastructure.database.repository.ProductGatewayDataBaseImpl;
import io.quarkus.test.junit.QuarkusTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.never;

@QuarkusTest
class DeleteProductTest {

    private final DeleteProductBoundary boundary;

    private final ProductGatewayDataBase dataBase;

    public DeleteProductTest() {
        dataBase = Mockito.mock(ProductGatewayDataBaseImpl.class);
        this.boundary = new DeleteProductInteractor(dataBase);
    }

    @Test
    @Description("deve executar com sucesso")
    void shouldDeleteProductSuccessfully() {
        final var boundaryInput = DeleteProductBoundaryInputFactory.getDefault();
        Mockito.when(dataBase.findbyId(Mockito.any())).thenReturn(Optional.of(GetProductDataBaseOutputFactory.getDefault()));
        Assertions.assertDoesNotThrow(() -> boundary.execute(boundaryInput));
        Mockito.verify(dataBase).delete(boundaryInput.id());
    }

    @Test
    @Description("Deve ser estourado uma exceção quando não for encontrado registro no banco")
    void shouldThrowExceptionWhenRecordNotFoundInDatabase() {
        final var boundaryInput = DeleteProductBoundaryInputFactory.getDefault();
        Mockito.when(dataBase.findbyId(Mockito.any())).thenReturn(Optional.empty());
        final var errorMessage = Assertions.assertThrows(ProductNotFoundException.class, () -> boundary.execute(boundaryInput));
        final var expected = "Product not found";
        Mockito.verify(dataBase, never()).delete(boundaryInput.id());
        Assertions.assertEquals(errorMessage.getMessage(), expected);
    }
}