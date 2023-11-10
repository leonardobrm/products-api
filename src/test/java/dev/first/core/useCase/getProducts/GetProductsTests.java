package dev.first.core.useCase.getProducts;

import dev.first.core.data.product.ProductGatewayDataBase;
import dev.first.core.factory.dataBase.GetProductsDataBaseOutputFactory;
import dev.first.core.factory.useCase.getProducts.GetProductsBoundaryInputFactory;
import dev.first.core.factory.useCase.getProducts.GetProductsBoundaryOutputFactory;
import dev.first.core.useCase.getProducts.interactor.GetProductsInteractor;
import dev.first.infrastructure.database.repository.ProductGatewayDataBaseImpl;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
class GetProductsTests {

    private final GetProductsBoundary boundary;

    private final ProductGatewayDataBase dataBase;

    public GetProductsTests() {
        dataBase = Mockito.mock(ProductGatewayDataBaseImpl.class);
        this.boundary = new GetProductsInteractor(dataBase);
    }

    @Test
    @DisplayName("deve executar com sucesso sem passar nenhum parametro")
    void shouldLoadDataSuccessfullyWithoutParameters() {
        final var input = GetProductsBoundaryInputFactory.getWithoutFields();
        Mockito.when(dataBase.getAllPaginated(Mockito.any())).thenReturn(GetProductsDataBaseOutputFactory.getDefault());
        final var output = boundary.execute(input);
        final var expected = GetProductsBoundaryOutputFactory.getDefault();
        Assertions.assertEquals(output, expected);
    }

    @Test
    @DisplayName("deve executar com sucesso quando não for encontrado valores")
    void shouldReturnEmptyListWhenNoValuesFound() {
        final var input = GetProductsBoundaryInputFactory.getDefault();
        Mockito.when(dataBase.getAllPaginated(Mockito.any())).thenReturn(GetProductsDataBaseOutputFactory.getWithoutProducts());
        final var output = boundary.execute(input);
        final var expected = GetProductsBoundaryOutputFactory.getWithoutProducts();
        Assertions.assertEquals(output, expected);
    }

    @Test
    @DisplayName("deve executar com sucesso quando o total for maior que o limite")
    void shouldRunSuccessfullyWhenTotalIsGreaterThanLimit() {
        final var input = GetProductsBoundaryInputFactory.getDefault();
        Mockito.when(dataBase.getAllPaginated(Mockito.any())).thenReturn(GetProductsDataBaseOutputFactory.getWithOneProduct());
        final var output = boundary.execute(input);
        final var expected = GetProductsBoundaryOutputFactory.getWithOneProduct();
        Assertions.assertEquals(output, expected);
    }
}
