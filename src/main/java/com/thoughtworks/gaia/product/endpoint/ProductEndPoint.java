package com.thoughtworks.gaia.product.endpoint;

import com.thoughtworks.gaia.common.exception.BadRequestException;
import com.thoughtworks.gaia.product.entity.Product;
import com.thoughtworks.gaia.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Path("product")
@Api(value = "product", description = "Access to product resource")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductEndPoint {
    @Autowired
    private ProductService productService;

    @Context
    private UriInfo uriInfo;

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

    @ApiOperation(value = "Create product", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Get products successfully")
    })
    @POST
    public Response createProduct(Product product) {
        Product productCreated = productService.create(product);
        return Response.created(uriInfo.getRequestUriBuilder().build("/" + productCreated.getId())).entity(productCreated).build();
    }

    @ApiOperation(value = "Get products by name and is_latest, if is_latest=true, return newest one, otherwise list with matched name",
            response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get products successfully")
    })
    @GET
    public List<Product> getProductByName(@QueryParam("name") String name, @QueryParam("is_latest") Boolean isLatest) {
        if (StringUtils.isEmpty(name)) {
            throw new BadRequestException();
        }
        if (Boolean.TRUE.equals(isLatest)) {
            Product latestProduct = productService.getLatestProductByName(name);
            return latestProduct != null ? Stream.of(latestProduct).collect(Collectors.toList()) : new ArrayList<>();
        }
        return productService.getProductsByName(name);
    }
}
