package dev.first.core.infrastructure.controller.mapper;

import dev.first.core.factory.useCase.createProducts.CreateProductsBoundaryInputFactory;
import dev.first.core.infrastructure.factory.controller.request.CreateProductRequestFactory;
import dev.first.infrastructure.controller.mapper.CreateProductControllerMapper;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@QuarkusTest
class CreateProductControllerMapperTest {

    @Test
    @DisplayName("Deve verificar o mapeamento do CreateProductBoundaryInput")
    void shouldVerifyTheCreateProductBoundaryInputMap() {
        final var input = CreateProductRequestFactory.getDefault();
        final var expected = CreateProductsBoundaryInputFactory.getDefault();
        final var output = CreateProductControllerMapper.convertTo(input);
        Assertions.assertEquals(output, expected);
    }
}
