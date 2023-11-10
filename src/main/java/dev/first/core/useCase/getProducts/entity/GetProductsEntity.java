package dev.first.core.useCase.getProducts.entity;

import dev.first.core.data.product.io.GetProductsDataBaseInput;
import dev.first.core.useCase.getProducts.io.GetProductsBoundaryInput;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public final class GetProductsEntity {

    private static final Integer PAGEABLE_SIZE_DEFAULT = 5;
    private static final Integer PAGEABLE_PAGE_DEFAULT = 0;

    private GetProductsEntity() {
    }

    public static GetProductsDataBaseInput createDataBaseInput(final GetProductsBoundaryInput input) {
        log.info("input={}", input);
        final var size = Objects.nonNull(input) && Objects.nonNull(input.size()) ? input.size() : PAGEABLE_SIZE_DEFAULT;
        final var page = Objects.nonNull(input) && Objects.nonNull(input.page()) ? input.page() : PAGEABLE_PAGE_DEFAULT;

        final var output = GetProductsDataBaseInput.builder()
                .size(size)
                .page(page)
                .build();

        log.info("output={}", output);
        return output;
    }
}
