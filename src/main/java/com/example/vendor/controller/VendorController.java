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

        // Initially fetch the Vendor Connections that are already present in the table
        Map<Long, VendorConnection> vendorConnections = getVendorConnections(vendorIdList);

        // Get a list of the missing vendor ids which is used later to create vendor connections
        List<Long> missingVendorConnections = getMissingVendorConnections(vendorConnections, vendorIdList);

        // Create a vendor connection for each vendor id and add it to the map
        missingVendorConnections.forEach(id -> vendorConnections.put(id, createVendorConnection(id)));

        return vendorConnections;
    }

    Map<Long, VendorConnection> getVendorConnections(List<Long> vendorIdList) {
        List<VendorConnection> vendorConnections = vendorConnectionRepository.findByVendorIdIn(vendorIdList);
        Map<Long, VendorConnection> connectionMap = new HashMap<>();
        vendorConnections.forEach(vendorConnection -> connectionMap.put(vendorConnection.getVendor().getId(), vendorConnection));
        return connectionMap;
    }

    List<Long> getMissingVendorConnections(Map<Long, VendorConnection> vendorConnections, List<Long> vendorIds) {
        List<Long> missingVendorConnections = new ArrayList<>();
        missingVendorConnections.addAll(vendorIds);
        missingVendorConnections.removeAll(vendorConnections.keySet());
        return missingVendorConnections;
    }

    VendorConnection createVendorConnection(Long vendorId) {
        // Write implementation to create vendor connection and return the VendorConnection
    }

}
