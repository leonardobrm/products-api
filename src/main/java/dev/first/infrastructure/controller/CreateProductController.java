package dev.first.infrastructure.controller;

import dev.first.core.useCase.createProduct.CreateProductBoundary;
import dev.first.core.useCase.createProduct.io.CreateProductBoundaryInput;
import dev.first.infrastructure.controller.request.CreateProductRequest;
import dev.first.utils.MapperUtils;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.reactive.RestResponse;

@Produces
@Path("/v1/products")
@Slf4j
public class CreateProductController {

    @Inject
    CreateProductBoundary boundary;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<?> execute(CreateProductRequest request) {
        log.info("request={}", request);
        final var boundaryInput = MapperUtils.map(request, CreateProductBoundaryInput.class);
        boundary.execute(boundaryInput);
        return RestResponse.status(RestResponse.Status.CREATED);
    }
}
