package dev.first.infrastructure.database.repository;

import dev.first.core.data.product.ProductGatewayDataBase;
import dev.first.core.data.product.io.*;
import dev.first.infrastructure.database.model.ProductDataBaseModel;
import dev.first.utils.MapperUtils;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
    @Transactional
    public void delete(Long id) {
        deleteById(id);
    }

    @Override
    public Optional<GetProductDataBaseOutput> findbyId(Long id) {
        final var productOptional = findByIdOptional(id);
        return MapperUtils.mapOptional(productOptional, GetProductDataBaseOutput.class);
    }
}