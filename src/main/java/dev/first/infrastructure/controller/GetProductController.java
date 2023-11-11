package dev.first.infrastructure.controller;

import dev.first.core.useCase.getProduct.GetProductBoundary;
import dev.first.core.useCase.getProduct.io.GetProductBoundaryInput;
import dev.first.infrastructure.controller.response.GetProductResponse;
import dev.first.utils.MapperUtils;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/v1/product")
@Slf4j
@RequiredArgsConstructor
public class GetProductController {

    private final GetProductBoundary boundary;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<GetProductResponse> execute(@RestPath Long id) {
        log.info("input={}", id);
        final var boundaryInput = GetProductBoundaryInput.builder().id(id).build();
        final var boundaryOutput = boundary.execute(boundaryInput);
        final var response = MapperUtils.map(boundaryOutput, GetProductResponse.class);
        log.info("output={}", response);
        return RestResponse.ok(response);
    }
}
