package com.chlima.tp1project.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductDto(
        String productId,
        String name,
        LocalDateTime createdAt,
        String category,
        BigDecimal price,
        String vendorId
) {
}
