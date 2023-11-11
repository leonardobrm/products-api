package dev.first.core.infrastructure.controller.mapper;

import dev.first.core.factory.useCase.updateProduct.UpdateProductBoundaryInputFactory;
import dev.first.core.infrastructure.factory.controller.request.UpdateProductRequestFactory;
import dev.first.infrastructure.controller.mapper.UpdateProductControllerMapper;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@QuarkusTest
class UpdateProductControllerTest {

    public UpdateProductControllerTest() {
    }

    @Test
    @DisplayName("Deve verificar o mapeamento do UpdateProductsBoundaryInput")
    void shouldVerifyTheUpdateProductBoundaryOutputMap() {
        final var input = UpdateProductRequestFactory.getDefault();
        final var expected = UpdateProductBoundaryInputFactory.getDefault();
        final var output = UpdateProductControllerMapper.convertTo(input);
        Assertions.assertEquals(output, expected);
    }
}
