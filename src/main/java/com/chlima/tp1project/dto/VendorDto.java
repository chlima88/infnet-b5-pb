package com.chlima.tp1project.dto;

import java.time.LocalDateTime;

public record VendorDto  (
        String id,
        String name,
        String email,
        LocalDateTime createdAt
){
}
