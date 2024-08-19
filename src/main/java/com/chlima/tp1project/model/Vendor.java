package com.chlima.tp1project.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Vendor {
    private String id;
    private LocalDateTime createdAt;
    private String name;
    private String email;

    public Vendor() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

    public static Vendor create(String name, String email){
        Vendor vendor = new Vendor();
        vendor.setName(name);
        vendor.setEmail(email);
        return vendor;
    }
}
