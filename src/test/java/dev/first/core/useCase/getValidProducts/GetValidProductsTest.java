package dev.first.core.useCase.getValidProducts;

import dev.first.core.data.product.ProductGatewayDataBase;
import dev.first.core.factory.dataBase.GetValidProductsDataBaseOutputFactory;
import dev.first.core.factory.useCase.getValidProducts.GetValidProductsBoundaryInputFactory;
import dev.first.core.factory.useCase.getValidProducts.GetValidProductsBoundaryOutputFactory;
import dev.first.core.useCase.getValidProducts.interactor.GetValidProductsInteractor;
import dev.first.infrastructure.database.repository.ProductGatewayDataBaseImpl;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
class GetValidProductsTest {

    private final GetValidProductsBoundary boundary;

    private final ProductGatewayDataBase dataBase;

    public GetValidProductsTest() {
        dataBase = Mockito.mock(ProductGatewayDataBaseImpl.class);
        this.boundary = new GetValidProductsInteractor(dataBase);
    }

    @Test
    @DisplayName("deve executar com sucesso sem passar nenhum parametro")
    void shouldLoadDataSuccessfullyWithoutParameters() {
        final var input = GetValidProductsBoundaryInputFactory.getWithoutFields();
        Mockito.when(dataBase.findAllValidPaginated(Mockito.any())).thenReturn(GetValidProductsDataBaseOutputFactory.getWithValidProducts());
        final var output = boundary.execute(input);
        final var expected = GetValidProductsBoundaryOutputFactory.getWithValidProducts();
        Assertions.assertEquals(output, expected);
    }

    @Test
    @DisplayName("deve executar com sucesso quando não for encontrado valores")
    void shouldReturnEmptyListWhenNoValuesFound() {
        final var input = GetValidProductsBoundaryInputFactory.getDefault();
        Mockito.when(dataBase.findAllValidPaginated(Mockito.any())).thenReturn(GetValidProductsDataBaseOutputFactory.getWithoutProducts());
        final var output = boundary.execute(input);
        final var expected = GetValidProductsBoundaryOutputFactory.getWithoutProducts();
        Assertions.assertEquals(output, expected);
    }

    @Test
    @DisplayName("deve executar com sucesso quando o total for maior que o limite")
    void shouldRunSuccessfullyWhenTotalIsGreaterThanLimit() {
        final var input = GetValidProductsBoundaryInputFactory.getDefault();
        Mockito.when(dataBase.findAllValidPaginated(Mockito.any())).thenReturn(GetValidProductsDataBaseOutputFactory.getWithOneProduct());
        final var output = boundary.execute(input);
        final var expected = GetValidProductsBoundaryOutputFactory.getWithOneProduct();
        Assertions.assertEquals(output, expected);
    }
}
