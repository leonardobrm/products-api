package dev.first.infrastructure.database.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Entity(name = "products")
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

    private LocalDate expiry_date;

    public ProductDataBaseModel() {
    }
}
