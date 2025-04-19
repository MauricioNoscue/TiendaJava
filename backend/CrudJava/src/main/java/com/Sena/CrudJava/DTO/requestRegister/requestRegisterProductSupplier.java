package com.Sena.CrudJava.DTO.requestRegister;

public class requestRegisterProductSupplier {
    private int productSupplierId;
    private int productId;
    private int supplierId;
    public int getProductSupplierId() {
        return productSupplierId;
    }
    public void setProductSupplierId(int productSupplierId) {
        this.productSupplierId = productSupplierId;
    }
    public requestRegisterProductSupplier() {
    }
    public requestRegisterProductSupplier(int productId, int supplierId,int productSupplierId) {
        this.productId = productId;
        this.supplierId = supplierId;
        this.productSupplierId = productSupplierId;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public int getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }


}
