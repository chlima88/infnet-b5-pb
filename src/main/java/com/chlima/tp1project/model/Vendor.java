package com.chlima.tp1project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Vendor {
    @Id
    private String vendorId;
    private LocalDateTime createdAt;
    private String name;
    private String email;
    @OneToMany(mappedBy = "productId")
    private List<Product> products;

    public Vendor() {
        this.vendorId = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

    public static Vendor create(String name, String email){
        Vendor vendor = new Vendor();
        vendor.setName(name);
        vendor.setEmail(email);
        return vendor;
    }
}
