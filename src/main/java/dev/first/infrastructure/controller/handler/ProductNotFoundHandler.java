package dev.first.infrastructure.controller.handler;

import dev.first.infrastructure.controller.handler.exception.ProductNotFoundException;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

@Provider
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class ProductNotFoundHandler implements ExceptionMapper<ProductNotFoundException> {
    @Override
    public Response toResponse(ProductNotFoundException exception) {
        final var message = exception.getMessage();
        log.info("status=404, body={}", message);
        return Response.status(Response.Status.NOT_FOUND.getStatusCode()).entity(message).build();
    }
}
