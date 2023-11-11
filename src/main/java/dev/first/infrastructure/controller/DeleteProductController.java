package dev.first.infrastructure.controller;

import dev.first.core.useCase.deleteProduct.DeleteProductBoundary;
import dev.first.core.useCase.deleteProduct.io.DeleteProductBoundaryInput;
import jakarta.ws.rs.DELETE;
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
public class DeleteProductController {

    private final DeleteProductBoundary boundary;

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<?> execute(@RestPath Long id) {
        log.info("input={}", id);
        final var boundaryInput = DeleteProductBoundaryInput.builder().id(id).build();
        boundary.execute(boundaryInput);
        log.info("output=N/A");
        return RestResponse.status(RestResponse.Status.NO_CONTENT);
    }
}
