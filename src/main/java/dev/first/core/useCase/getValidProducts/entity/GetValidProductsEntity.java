package dev.first.core.useCase.getValidProducts.entity;

import dev.first.core.data.product.io.GetValidProductsDataBaseInput;
import dev.first.core.useCase.getValidProducts.io.GetValidProductsBoundaryInput;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public final class GetValidProductsEntity {

    private GetValidProductsEntity() {
    }

    private static final Integer PAGEABLE_SIZE_DEFAULT = 5;
    private static final Integer PAGEABLE_PAGE_DEFAULT = 0;

    public static GetValidProductsDataBaseInput createDataBaseInput(final GetValidProductsBoundaryInput input) {
        log.info("input={}", input);
        final var size = Objects.nonNull(input) && Objects.nonNull(input.size()) ? input.size() : PAGEABLE_SIZE_DEFAULT;
        final var page = Objects.nonNull(input) && Objects.nonNull(input.page()) ? input.page() : PAGEABLE_PAGE_DEFAULT;

        final var output = GetValidProductsDataBaseInput.builder()
                .size(size)
                .page(page)
                .build();
        log.info("output={}", output);
        return output;
    }
}
