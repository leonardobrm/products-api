package dev.first.infrastructure.controller.request;

public record UpdateProductRequest(String name, Integer quantity, String description, String expiry_date) {
}
