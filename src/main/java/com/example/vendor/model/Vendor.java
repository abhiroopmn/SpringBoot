package com.example.vendor.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vendor")
public class Vendor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // For Oracle DB you might need to modify the GeneratedValue tag since Oracle might not support IDENTITY by default

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
