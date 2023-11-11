package dev.first.core.infrastructure.controller.mapper;

import dev.first.core.factory.useCase.getProducts.GetProductsBoundaryOutputFactory;
import dev.first.core.infrastructure.factory.controller.response.GetProductsResponseFactory;
import dev.first.infrastructure.controller.mapper.GetProductsControllerMapper;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@QuarkusTest
class GetProductsControllerMapperTest {

    private GetProductsControllerMapperTest() {
    }

    @Test
    @DisplayName("Deve verificar o mapeamento do GetProductsResponse")
    void shouldVerifyTheGetProductResponseMap() {
        final var input = GetProductsBoundaryOutputFactory.getDefault();
        final var expected = GetProductsResponseFactory.getDefault();
        final var output = GetProductsControllerMapper.convertTo(input);
        Assertions.assertEquals(output, expected);
    }
}
