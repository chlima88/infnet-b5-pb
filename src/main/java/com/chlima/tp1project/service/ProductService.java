package com.chlima.tp1project.service;

import com.chlima.tp1project.dto.CreateProductDto;
import com.chlima.tp1project.dto.ProductDto;
import com.chlima.tp1project.model.Product;
import com.chlima.tp1project.model.Vendor;
import com.chlima.tp1project.repository.ProductRepository;
import com.chlima.tp1project.repository.VendorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.lang.model.UnknownEntityException;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final VendorRepository vendorRepository;

    public ProductService(ProductRepository productRepository, VendorRepository vendorRepository) {
        this.productRepository = productRepository;
        this.vendorRepository = vendorRepository;
    }

    public ProductDto createProduct(CreateProductDto producDto) {
        Vendor vendor = vendorRepository.getById(producDto.vendorId())
                .orElseThrow();
        Product product = Product.create(
                producDto.name(),
                producDto.category(),
                producDto.price(),
                vendor
        );

        return toProductDto(productRepository.save(product));
    }

    public ProductDto getProductById(String productId) {
        return toProductDto(productRepository.findById(productId)
                .orElseThrow());

    }

    public List<ProductDto> listProducts() {
        return productRepository.findAll().stream()
                .map(ProductService::toProductDto).toList();
    }

    public void deleteById(String productId) {
        productRepository.removeById(productId);
    }

    private static ProductDto toProductDto(Product product){
        return new ProductDto(
                product.getProductId(),
                product.getName(),
                product.getCreatedAt(),
                product.getCategory(),
                product.getPrice(),
                product.getVendor().getId()
        );
    }
}
