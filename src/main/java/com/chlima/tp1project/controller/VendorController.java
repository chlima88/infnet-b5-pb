package com.chlima.tp1project.controller;

import com.chlima.tp1project.dto.CreateVendorDto;
import com.chlima.tp1project.dto.VendorDto;
import com.chlima.tp1project.repository.VendorRepository;
import com.chlima.tp1project.service.VendorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Vendor")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService =  vendorService;
    }

    @Operation(summary = "List vendors", description = "Lists all registered vendors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
    })
    @GetMapping("/vendors")
    public ResponseEntity<List<VendorDto>> listVendors() {
        return ResponseEntity.ok().body(vendorService.getList());
    }

    @Operation(summary = "Get vendor by id", description = "Gets information about a registered vendor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
    })
    @GetMapping("/vendors/{vendorId}")
    public ResponseEntity<VendorDto> getVendor(@PathVariable String vendorId) {
        return ResponseEntity.ok().body(vendorService.getById(vendorId));
    }

    @Operation(summary = "Create vendor", description = "Register a vendor with the provided information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Success", content = @Content),
    })
    @PostMapping("/vendors")
    public ResponseEntity<VendorDto> createVendor(@RequestBody CreateVendorDto vendorDto){
        return ResponseEntity.ok().body(vendorService.createVendor(vendorDto));
    }

    @Operation(summary = "Delete vendor", description = "Remove a vendor register")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
    })
    @DeleteMapping("/vendors/{vendorId}")
    public ResponseEntity<Void> deleteVendor(@PathVariable String vendorId){
        vendorService.deleteById(vendorId);
        return ResponseEntity.noContent().build();
    }
}
