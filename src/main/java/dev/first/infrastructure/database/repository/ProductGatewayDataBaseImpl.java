package dev.first.infrastructure.database.repository;

import dev.first.core.data.product.ProductGatewayDataBase;
import dev.first.core.data.product.io.*;
import dev.first.infrastructure.database.model.ProductDataBaseModel;
import dev.first.utils.MapperUtils;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
@Slf4j
public class ProductGatewayDataBaseImpl implements ProductGatewayDataBase {

    @Override
    @Transactional
    public void save(CreateProductDataBaseInput input) {
        final var dataBaseModel = ProductDataBaseModel.builder()
                .name(input.name())
                .description(input.description())
                .quantity(input.quantity())
                .expiry_date(input.expiry_date())
                .build();
        persist(dataBaseModel);
    }

    @Override
    public GetProductsDataBaseOutput findAllPaginated(GetProductsDataBaseInput input) {
        log.info("input={}", input);
        final var products = findAll().page(input.page(), input.size());

        final var content = MapperUtils.mapList(products.list(), GetProductsContentDataBaseOutput.class);
        final var pageable = GetProductsPageableDataBaseOutput.builder()
                .pageNumber(products.page().index)
                .pageSize(products.page().size)
                .totalElements(products.count())
                .build();

        final var output = GetProductsDataBaseOutput.builder()
                .products(content)
                .pageable(pageable)
                .build();
        log.info("output={}", output);
        return output;
    }

    @Override
    public GetValidProductsDataBaseOutput findAllValidPaginated(GetValidProductsDataBaseInput input) {
        log.info("input={}", input);
        final var products = find("expiry_date > ?1", LocalDateTime.now()).page(input.page(), input.size());

        final var content = MapperUtils.mapList(products.list(), GetValidProductsContentDataBaseOutput.class);
        final var pageable = GetValidProductsPageableDataBaseOutput.builder()
                .pageNumber(products.page().index)
                .pageSize(products.page().size)
                .totalElements(products.count())
                .build();

        final var output = GetValidProductsDataBaseOutput.builder()
                .products(content)
                .pageable(pageable)
                .build();

        log.info("output={}", output);
        return output;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        deleteById(id);
    }

    @Override
    public Optional<GetProductDataBaseOutput> findbyId(Long id) {
        final var productOptional = findByIdOptional(id);
        return MapperUtils.mapOptional(productOptional, GetProductDataBaseOutput.class);
    }

    @Override
    @Transactional
    public void update(UpdateProductDataBaseInput input, Long id) {
        final var updateQuery = "name = :name, description = :description, quantity = :quantity, expiry_date = :expiryDate where id = :id";

        update(updateQuery,
                Parameters.with("name", input.name())
                        .and("description", input.description())
                        .and("quantity", input.quantity())
                        .and("expiryDate", input.expiry_date())
                        .and("id", id));
    }
}