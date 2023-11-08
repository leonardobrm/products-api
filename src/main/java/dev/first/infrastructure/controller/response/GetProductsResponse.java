package dev.first.infrastructure.controller.response;

import java.util.Date;

public record GetProductsResponse(String id, String name, Integer quantity, String description, Date expirt_date) {
}
