package com.thoughtworks.gaia.product.endpoint;

import com.thoughtworks.gaia.product.entity.Product;
import com.thoughtworks.gaia.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("product")
@Api(value = "product", description = "Access to product resource")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductEndPoint {
    @Autowired
    private ProductService productService;

    @Path("/{product_id}")
    @ApiOperation(value = "Get product by id", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get product successfully"),
            @ApiResponse(code = 404, message = "No product matches given id")
    })
    @GET
    public Response getProduct(@PathParam("product_id") Long productId) {
        Product product = productService.getProduct(productId);
        return Response.ok().entity(product).build();
    }
}
