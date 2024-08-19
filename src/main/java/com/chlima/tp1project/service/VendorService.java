package com.chlima.tp1project.service;

import com.chlima.tp1project.dto.CreateVendorDto;
import com.chlima.tp1project.dto.VendorDto;
import com.chlima.tp1project.model.Vendor;
import com.chlima.tp1project.repository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {
    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public VendorDto getById(String vendorId){
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow();
        return toVendorDto(vendor);
    }

    public List<VendorDto> getList() {
        return vendorRepository.findAll().stream()
                .map(VendorService::toVendorDto).toList();
    }

    public VendorDto createVendor(CreateVendorDto vendorDto) {
        Vendor vendor = Vendor.create(
                vendorDto.name(),
                vendorDto.email()
        );
        vendorRepository.save(vendor);
        return toVendorDto(vendor);
    }

    public void deleteById(String vendorId){
        vendorRepository.deleteById(vendorId);
    }

    private static VendorDto toVendorDto(Vendor vendor) {
        return new VendorDto(
                vendor.getVendorId(),
                vendor.getName(),
                vendor.getEmail(),
                vendor.getCreatedAt()
        );
    }

}
