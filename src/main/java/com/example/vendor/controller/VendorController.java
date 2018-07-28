package com.example.vendor.controller;

import com.example.vendor.model.Vendor;
import com.example.vendor.model.VendorConnection;
import com.example.vendor.repository.VendorRepository;
import com.example.vendor.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @Autowired
    private VendorRepository vendorRepository;

    @RequestMapping("/{id}")
    @ResponseBody
    public VendorConnection getVendorConnection(@PathVariable("id") String vendorId) {
        Optional<Vendor> vendor = vendorRepository.findById(Long.valueOf(vendorId));
        if (vendor.isPresent()) {
            return vendorService.getVendorConnection(vendor.get());
        } else {
            return null;
        }
    }

}
