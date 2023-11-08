package dev.first.infrastructure.controller.handler.response;

import jakarta.validation.ConstraintViolationException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@ToString
public final class ConstrainsHandlerModelResponse {

    private List<ConstrainsFieldHandlerModelResponse> errors;

    private ConstrainsHandlerModelResponse() {
    }

    public ConstrainsHandlerModelResponse(final ConstraintViolationException exception) {

        errors = new ArrayList<>();
        exception.getConstraintViolations().stream().iterator().forEachRemaining(constraintViolation -> errors.add(ConstrainsFieldHandlerModelResponse
                .builder()
                .message(constraintViolation.getMessage())
                .build()));
        errors.sort(Comparator.comparing(ConstrainsFieldHandlerModelResponse::getMessage));
    }
}
