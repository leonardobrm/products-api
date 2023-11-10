package dev.first.infrastructure.controller;

import dev.first.core.useCase.getProducts.GetProductsBoundary;
import dev.first.core.useCase.getProducts.io.GetProductsBoundaryInput;
import dev.first.infrastructure.controller.response.GetProductsResponse;
import dev.first.utils.MapperUtils;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.reactive.RestQuery;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/v1/products")
@Slf4j
@RequiredArgsConstructor
public class GetProductsController {

    private final GetProductsBoundary boundary;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<GetProductsResponse> execute(@RestQuery Integer page, @RestQuery Integer size) {
        log.info("request={}{}", page, size);
        final var boundaryInput = GetProductsBoundaryInput.builder()
                .page(page)
                .size(size)
                .build();
        final var listOfProducts = boundary.execute(boundaryInput);
        final var response = MapperUtils.map(listOfProducts, GetProductsResponse.class);
        log.info("response={}", response);
        return RestResponse.ok(response);
    }
}
