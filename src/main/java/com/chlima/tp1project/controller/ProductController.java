package com.chlima.tp1project.controller;

import com.chlima.tp1project.dto.CreateProductDto;
import com.chlima.tp1project.dto.ProductDto;
import com.chlima.tp1project.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Product")
public class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "List products", description = "Lists all registered products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
    })
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> listProducts() {
        return ResponseEntity.ok().body(productService.listProducts());
    }

    @Operation(summary = "Get product by id", description = "Gets information about a registered product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
    })
    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable String productId){
        return ResponseEntity.ok().body(productService.getProductById(productId));
    }

    @Operation(summary = "Create product", description = "Register a product with the provided information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Success", content = @Content),
    })
    @PostMapping("/products")
    public ResponseEntity<ProductDto> createProduct(@RequestBody CreateProductDto productDto) {
        return ResponseEntity.ok().body(productService.createProduct(productDto));
    }

    @Operation(summary = "Delete product", description = "Remove a product register")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
    })
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
        productService.deleteById(productId);
        return ResponseEntity.noContent().build();
    }
}
