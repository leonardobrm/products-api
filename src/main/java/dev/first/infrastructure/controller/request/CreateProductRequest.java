package dev.first.infrastructure.controller.request;

import java.util.Date;

public record CreateProductRequest(String name, Integer quantity, String description, String expiry_date) {
}
