package dev.first.infrastructure.controller;

import dev.first.core.useCase.createProduct.CreateProductBoundary;
import dev.first.infrastructure.controller.mapper.CreateProductControllerMapper;
import dev.first.infrastructure.controller.request.CreateProductRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.reactive.RestResponse;

@Produces
@Path("/v1/product")
@Slf4j
@RequiredArgsConstructor
public class CreateProductController {

    private final CreateProductBoundary boundary;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<?> execute(CreateProductRequest request) {
        log.info("request={}", request);
        final var boundaryInput = CreateProductControllerMapper.convertTo(request);
        boundary.execute(boundaryInput);
        return RestResponse.status(RestResponse.Status.CREATED);
    }
}
