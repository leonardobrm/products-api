package dev.first.infrastructure.controller;

import dev.first.core.useCase.getValidProducts.GetValidProductsBoundary;
import dev.first.core.useCase.getValidProducts.io.GetValidProductsBoundaryInput;
import dev.first.infrastructure.controller.response.GetValidProductsResponse;
import dev.first.utils.MapperUtils;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.reactive.RestQuery;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/v1/product/valid")
@Slf4j
@RequiredArgsConstructor
public class GetValidProductsController {

    private final GetValidProductsBoundary boundary;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<GetValidProductsResponse> execute(@RestQuery Integer page, @RestQuery Integer size) {
        log.info("request={}{}", page, size);
        final var boundaryInput = GetValidProductsBoundaryInput.builder()
                .page(page)
                .size(size)
                .build();
        final var listOfProducts = boundary.execute(boundaryInput);
        final var response = MapperUtils.map(listOfProducts, GetValidProductsResponse.class);
        log.info("response={}", response);
        return RestResponse.ok(response);
    }
}
