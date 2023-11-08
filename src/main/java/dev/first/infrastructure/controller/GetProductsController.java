package dev.first.infrastructure.controller;

import dev.first.core.useCase.getProducts.GetProductsBoundary;
import dev.first.infrastructure.controller.response.GetProductsResponse;
import dev.first.utils.MapperUtils;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Path("/v1/products")
@Slf4j
public class GetProductsController {

    @Inject
    GetProductsBoundary boundary;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GetProductsResponse execute() {
        log.info("request=N/A");
        final var listOfProducts = boundary.execute();
        final var response = MapperUtils.map(listOfProducts, GetProductsResponse.class);
        log.info("response={}", response);
        return response;
    }
}
