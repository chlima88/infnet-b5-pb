package com.chlima.tp1project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Product {
    @Id
    private String productId;
    private LocalDateTime createdAt;
    private String name;
    private String category;
    private BigDecimal price;
    @ManyToOne @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    protected Product() {
        this.productId = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

    public static Product create(String name, String category, BigDecimal price, Vendor vendor){
        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setPrice(price);
        product.setVendor(vendor);
        return product;
    }

}
