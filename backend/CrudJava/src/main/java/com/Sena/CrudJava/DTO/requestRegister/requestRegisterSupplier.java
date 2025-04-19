package com.Sena.CrudJava.DTO.requestRegister;

public class requestRegisterSupplier {
 private int supplierID;
 private String address;
 private String supplierName;
 private String phone;
 private String email;


 
 public requestRegisterSupplier() {
}   

 public requestRegisterSupplier(int supplierID, String address, String supplierName, String phone, String email) {
    this.supplierID = supplierID;
    this.address = address;
    this.supplierName = supplierName;
    this.phone = phone;
    this.email = email;
}

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

