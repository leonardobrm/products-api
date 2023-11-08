package dev.first.core.getProducts.interactor;

import dev.first.core.getProducts.GetProductsBoundary;
import dev.first.core.getProducts.io.GetProductsBoundaryOutput;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Date;

@ApplicationScoped
public class GetProductsInteractor implements GetProductsBoundary {

    @Override
    public GetProductsBoundaryOutput execute() {
        return GetProductsBoundaryOutput.builder()
                .id("182109821")
                .name("product teste")
                .description("produto teste")
                .quantity(5)
                .expirt_date(new Date())
                .build();
    }
}
