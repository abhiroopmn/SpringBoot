package com.example.vendor.controller;

import com.example.vendor.model.Vendor;
import com.example.vendor.model.VendorConnection;
import com.example.vendor.repository.VendorConnectionRepository;
import com.example.vendor.repository.VendorRepository;
import com.example.vendor.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private VendorConnectionRepository vendorConnectionRepository;

    @RequestMapping("/{id}")
    @ResponseBody
    public Map<Long, VendorConnection> getVendorConnection(@PathVariable("id") String vendorId) {
//        Optional<Vendor> vendor = vendorRepository.findById(Long.valueOf(vendorId));
//        if (vendor.isPresent()) {
//            return vendorService.getVendorConnection(vendor.get());
//        } else {
//            return null;
//        }
        List<Long> vendorIdList = new ArrayList<>();
        vendorIdList.add(2L);
        vendorIdList.add(3L);
        return getVendorConnections(vendorIdList);
    }

    Map<Long, VendorConnection> getVendorConnections(List<Long> vendorIdList) {
        List<VendorConnection> vendorConnections = vendorConnectionRepository.findByVendorIdIn(vendorIdList);
        Map<Long, VendorConnection> connectionMap = new HashMap<>();
        vendorConnections.forEach(vendorConnection -> connectionMap.put(vendorConnection.getVendor().getId(), vendorConnection));
        return connectionMap;
    }

}
