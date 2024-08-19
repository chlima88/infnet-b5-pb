package com.chlima.tp1project.repository;

import com.chlima.tp1project.model.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl {
    private static Map<String, Product> db;

    public ProductRepositoryImpl(){
        db = ProductRepositoryImpl.db != null
                ? ProductRepositoryImpl.db
                : new HashMap<>();
    }

    public Optional<Product> findById(String id) {
        return Optional.of(db.get(id));
    }

    public List<Product> findAll(){
        return this.db.values().stream().collect(Collectors.toList());
    }

    public void removeById(String id) {
        this.db.remove(id);
    }

    public Product save(Product product) {
        this.db.put(product.getProductId(), product);
        return product;
    }
}
