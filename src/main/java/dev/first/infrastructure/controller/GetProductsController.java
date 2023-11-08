package dev.first.infrastructure.controller;

import dev.first.core.getProducts.GetProductsBoundary;
import dev.first.infrastructure.controller.response.GetProductsResponse;
import dev.first.utils.MapperUtils;
import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/products")

public class GetProductsController {

    @Inject
    GetProductsBoundary boundary;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GetProductsResponse getProducts() {
        Log.debug("input=N/A");
        final var listOfProducts = boundary.execute();
        final var output = MapperUtils.map(listOfProducts, GetProductsResponse.class);
        Log.debug(output);
        return output;
    }
}
