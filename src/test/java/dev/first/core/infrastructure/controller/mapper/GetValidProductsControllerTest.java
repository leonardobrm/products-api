package dev.first.core.infrastructure.controller.mapper;

import dev.first.core.factory.useCase.getValidProducts.GetValidProductsBoundaryOutputFactory;
import dev.first.core.infrastructure.factory.controller.response.GetValidProductsResponseFactory;
import dev.first.infrastructure.controller.mapper.GetValidProductsControllerMapper;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@QuarkusTest
class GetValidProductsControllerTest {

    private GetValidProductsControllerTest() {
    }

    @Test
    @DisplayName("Deve verificar o mapeamento do GetValidProductsResponse")
    void shouldVerifyTheGetValidProductResponseMap() {
        final var input = GetValidProductsBoundaryOutputFactory.getDefault();
        final var expected = GetValidProductsResponseFactory.getDefault();
        final var output = GetValidProductsControllerMapper.convertTo(input);
        Assertions.assertEquals(output, expected);
    }
}
