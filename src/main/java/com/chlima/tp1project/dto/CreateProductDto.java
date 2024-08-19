package com.chlima.tp1project.dto;

import java.math.BigDecimal;

public record CreateProductDto(
        String name,
        String category,
        BigDecimal price,
        String vendorId
) { }
