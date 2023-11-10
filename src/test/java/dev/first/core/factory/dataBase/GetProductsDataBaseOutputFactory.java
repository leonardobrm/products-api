package dev.first.core.factory.dataBase;

import dev.first.core.data.product.io.GetProductsContentDataBaseOutput;
import dev.first.core.data.product.io.GetProductsDataBaseOutput;
import dev.first.core.data.product.io.GetProductsPageableDataBaseOutput;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public final class GetProductsDataBaseOutputFactory {

    private GetProductsDataBaseOutputFactory() {
    }

    public static GetProductsDataBaseOutput getDefault() {
        return getGetProductsDataBaseOutputDefault();
    }

    public static GetProductsDataBaseOutput getWithoutProducts() {
        return getGetProductsDataBaseOutputDefault().toBuilder()
                .products(List.of())
                .pageable(getGetProductsPageableDataBaseOutputDefault().toBuilder()
                        .pageSize(2)
                        .pageNumber(0)
                        .totalElements(5L)
                        .build())
                .build();
    }

    public static GetProductsDataBaseOutput getWithOneProduct() {
        return getGetProductsDataBaseOutputDefault().toBuilder()
                .products(List.of(getGetProductsContentDataBaseOutputDefault()))
                .pageable(getGetProductsPageableDataBaseOutputDefault().toBuilder()
                        .pageSize(2)
                        .pageNumber(0)
                        .totalElements(1L)
                        .build())
                .build();
    }

    private static GetProductsContentDataBaseOutput getGetProductsContentDataBaseOutputDefault() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        final var date = LocalDate.parse("09-11-2023", formatter).atStartOfDay();

        return GetProductsContentDataBaseOutput.builder()
                .id(1L)
                .description("produto teste")
                .name("produto teste")
                .expiry_date(date)
                .quantity(2)
                .build();
    }

    private static GetProductsPageableDataBaseOutput getGetProductsPageableDataBaseOutputDefault() {
        return GetProductsPageableDataBaseOutput.builder()
                .pageSize(5)
                .pageNumber(0)
                .totalElements(5L)
                .build();
    }

    private static GetProductsDataBaseOutput getGetProductsDataBaseOutputDefault() {
        return GetProductsDataBaseOutput.builder()
                .products(List.of(getGetProductsContentDataBaseOutputDefault(),
                        getGetProductsContentDataBaseOutputDefault(),
                        getGetProductsContentDataBaseOutputDefault(),
                        getGetProductsContentDataBaseOutputDefault(),
                        getGetProductsContentDataBaseOutputDefault()))
                .pageable(getGetProductsPageableDataBaseOutputDefault())
                .build();
    }
}
