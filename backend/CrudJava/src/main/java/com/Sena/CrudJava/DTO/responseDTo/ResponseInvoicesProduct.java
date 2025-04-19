package com.Sena.CrudJava.DTO.responseDTo;

public class ResponseInvoicesProduct {
    private int invoicesId;
    private String invoicesName;
    private int productId;
    private String productName;
    public ResponseInvoicesProduct() {
    }
    public ResponseInvoicesProduct(int invoicesId, String invoicesName, int productId, String productName) {
        this.invoicesId = invoicesId;
        this.invoicesName = invoicesName;
        this.productId = productId;
        this.productName = productName;
    }
    public int getInvoicesId() {
        return invoicesId;
    }
    public void setInvoicesId(int invoicesId) {
        this.invoicesId = invoicesId;
    }
    public String getInvoicesName() {
        return invoicesName;
    }
    public void setInvoicesName(String invoicesName) {
        this.invoicesName = invoicesName;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

}
