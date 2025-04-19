package com.Sena.CrudJava.DTO.responseDTo;

public class ResponseProductSupplier {

    private Integer productId;
    private String productName;
    private Integer supplierId;
    private String supplierName;

    public ResponseProductSupplier() {
    }

    public ResponseProductSupplier(Integer productId, String productName, Integer supplierId, String supplierName) {
        this.productId = productId;
        this.productName = productName;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }
}
