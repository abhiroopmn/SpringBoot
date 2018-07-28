package com.example.vendor.repository;

import com.example.vendor.model.Vendor;
import com.example.vendor.model.VendorConnection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorConnectionRepository extends CrudRepository<VendorConnection, Long> {

    VendorConnection findByVendor(Vendor vendor);
}
