package dev.first.infrastructure.controller;

import dev.first.core.useCase.updateProduct.UpdateProductBoundary;
import dev.first.infrastructure.controller.mapper.UpdateProductControllerMapper;
import dev.first.infrastructure.controller.request.UpdateProductRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/v1/product")
@RequiredArgsConstructor
@Slf4j
public class UpdateProductController {

    private final UpdateProductBoundary boundary;

    @PUT
    @Path(("/{id}"))
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<?> execute(@RestPath Long id, UpdateProductRequest request) {
        log.info("request={}{}", id, request);
        final var boundaryInput = UpdateProductControllerMapper.convertTo(request);
        boundary.execute(boundaryInput, id);
        log.info("output=N/A");
        return RestResponse.status(RestResponse.Status.NO_CONTENT);
    }
}
