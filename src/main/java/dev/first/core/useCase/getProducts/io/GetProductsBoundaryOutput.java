package dev.first.core.useCase.getProducts.io;

import lombok.Builder;

import java.util.Date;

@Builder
public record GetProductsBoundaryOutput(String id, String name, Integer quantity, String description, Date expirt_date) {
}
