package dev.first.infrastructure.database.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class ProductDataBaseModel {

    private final String id;

    private final String description;

    private final String name;

    private final Integer quantity;

    private final LocalDate expiry_date;
}
