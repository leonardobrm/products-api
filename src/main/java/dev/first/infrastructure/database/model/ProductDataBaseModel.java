package dev.first.infrastructure.database.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity(name = "products")
@Table
@Builder
@Getter
@AllArgsConstructor
public class ProductDataBaseModel extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String name;

    private Integer quantity;

    private LocalDateTime expiry_date;

    public ProductDataBaseModel() {
    }
}
