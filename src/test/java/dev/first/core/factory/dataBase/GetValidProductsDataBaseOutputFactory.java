package dev.first.core.factory.dataBase;

import dev.first.core.data.product.io.GetValidProductsContentDataBaseOutput;
import dev.first.core.data.product.io.GetValidProductsDataBaseOutput;
import dev.first.core.data.product.io.GetValidProductsPageableDataBaseOutput;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public final class GetValidProductsDataBaseOutputFactory {

    private GetValidProductsDataBaseOutputFactory() {
    }

    public static GetValidProductsDataBaseOutput getDefault() {
        return getValidProductsDataBaseOutputDefault();
    }

    public static GetValidProductsDataBaseOutput getWithValidProducts() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        final var date = LocalDate.parse("09-11-2023", formatter).atStartOfDay();

        return GetValidProductsDataBaseOutput.builder()
                .products(List.of(
                        getValidProductsContentDataBaseOutputDefault().toBuilder()
                                .id(1L)
                                .description("produto teste")
                                .name("produto teste")
                                .expiry_date(date.plusDays(1))
                                .quantity(2)
                                .build()
                ))
                .pageable(getValidProductsPageableDataBaseOutputDefault().toBuilder()
                        .pageSize(2)
                        .pageNumber(0)
                        .totalElements(1L)
                        .build())
                .build();
    }

    public static GetValidProductsDataBaseOutput getWithoutProducts() {
        return getValidProductsDataBaseOutputDefault().toBuilder()
                .products(List.of())
                .pageable(getValidProductsPageableDataBaseOutputDefault().toBuilder()
                        .pageSize(2)
                        .pageNumber(0)
                        .totalElements(5L)
                        .build())
                .build();
    }

    public static GetValidProductsDataBaseOutput getWithOneProduct() {
        return getValidProductsDataBaseOutputDefault().toBuilder()
                .products(List.of(getValidProductsContentDataBaseOutputDefault()))
                .pageable(getValidProductsPageableDataBaseOutputDefault().toBuilder()
                        .pageSize(2)
                        .pageNumber(0)
                        .totalElements(1L)
                        .build())
                .build();
    }

    private static GetValidProductsContentDataBaseOutput getValidProductsContentDataBaseOutputDefault() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        final var date = LocalDate.parse("09-11-2023", formatter).atStartOfDay();

        return GetValidProductsContentDataBaseOutput.builder()
                .id(1L)
                .description("produto teste")
                .name("produto teste")
                .expiry_date(date)
                .quantity(2)
                .build();
    }

    private static GetValidProductsPageableDataBaseOutput getValidProductsPageableDataBaseOutputDefault() {
        return GetValidProductsPageableDataBaseOutput.builder()
                .pageSize(5)
                .pageNumber(0)
                .totalElements(5L)
                .build();
    }

    private static GetValidProductsDataBaseOutput getValidProductsDataBaseOutputDefault() {
        return GetValidProductsDataBaseOutput.builder()
                .products(List.of(getValidProductsContentDataBaseOutputDefault(),
                        getValidProductsContentDataBaseOutputDefault(),
                        getValidProductsContentDataBaseOutputDefault(),
                        getValidProductsContentDataBaseOutputDefault(),
                        getValidProductsContentDataBaseOutputDefault(),
                        getValidProductsContentDataBaseOutputDefault().toBuilder()
                                .id(1L)
                                .description("produto teste")
                                .name("produto teste")
                                .expiry_date(LocalDateTime.now().plusDays(1))
                                .quantity(2)
                                .build()
                ))
                .pageable(getValidProductsPageableDataBaseOutputDefault())
                .build();
    }
}
