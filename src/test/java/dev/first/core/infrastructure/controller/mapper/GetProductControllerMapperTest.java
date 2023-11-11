package dev.first.core.infrastructure.controller.mapper;

import dev.first.core.factory.useCase.getProduct.GetProductBoundaryOutputFactory;
import dev.first.core.infrastructure.factory.controller.response.GetProductResponseFactory;
import dev.first.infrastructure.controller.mapper.GetProductControllerMapper;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@QuarkusTest
class GetProductControllerMapperTest {

    private GetProductControllerMapperTest() {
    }

    @Test
    @DisplayName("Deve verificar o mapeamento do GetProductResponse")
    void shouldVerifyTheGetProductResponseMap() {
        final var input = GetProductBoundaryOutputFactory.getDefault();
        final var expected = GetProductResponseFactory.getDefault();
        final var output = GetProductControllerMapper.convertTo(input);
        Assertions.assertEquals(output, expected);
    }
}
