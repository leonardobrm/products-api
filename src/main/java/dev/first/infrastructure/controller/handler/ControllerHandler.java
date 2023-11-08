package dev.first.infrastructure.controller.handler;

import dev.first.infrastructure.controller.handler.response.ConstrainsHandlerModelResponse;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;


@Provider
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class ControllerHandler implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        final var errorMessages = new ConstrainsHandlerModelResponse(exception);
        log.info("Erro de validacao: status=400, body={}", errorMessages);
        return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(errorMessages).build();
    }
}