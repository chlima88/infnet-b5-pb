package com.chlima.tp1project.repository;

import com.chlima.tp1project.model.Vendor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class VendorRepository {
    private static Map<String, Vendor> db;

    public VendorRepository(){
        db = VendorRepository.db != null
                ? VendorRepository.db
                : new HashMap<>();
    }
    
    public Optional<Vendor> getById(String id) {
        return Optional.of(db.get(id));
    }
    
    public List<Vendor> list(){
        return this.db.values().stream().collect(Collectors.toList());
    }
    
    public void deleteById(String id) {
        this.db.remove(id);
    }
    
    public Vendor save(Vendor vendor) {
        this.db.put(vendor.getId(), vendor);
        return vendor;
    }

}
