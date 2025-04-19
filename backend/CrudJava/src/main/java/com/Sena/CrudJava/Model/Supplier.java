package com.Sena.CrudJava.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "Supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "SupplierId")
    private int supplierID;
    @Column(name = "address")
    private String address;
    @Column(name = "supplierName")
    private String supplierName;
    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "supplier", cascade= CascadeType.ALL,orphanRemoval = true)
    private List<ProductSupplier> productSupplier = new ArrayList<>(); 


    public Supplier(int supplierID, String address, String supplierName, String phone, String email) {
        this.supplierID = supplierID;
        this.address = address;
        this.supplierName = supplierName;
        this.phone = phone;
        this.email = email;
    }
    public Supplier() {
    }
    @Column(name = "email")
    private String email;
    public int getSupplierID() {
        return supplierID;
    }
    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getSupplierName() {
        return supplierName;
    }
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
