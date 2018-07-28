package com.example.vendor.service;

import com.example.vendor.model.Vendor;
import com.example.vendor.model.VendorConnection;
import com.example.vendor.repository.VendorConnectionRepository;
import com.example.vendor.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class VendorService {

    @Autowired
    private VendorConnectionRepository vendorConnectionRepository;

    @Autowired
    private VendorRepository vendorRepository;

    public VendorConnection getVendorConnection(Vendor vendor) {
        return vendorConnectionRepository.findByVendor(vendor);
    }

}
