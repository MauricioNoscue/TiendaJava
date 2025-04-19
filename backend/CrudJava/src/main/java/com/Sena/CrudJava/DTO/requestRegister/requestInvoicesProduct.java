package com.Sena.CrudJava.DTO.requestRegister;

public class requestInvoicesProduct {


    private int invoicesProductId;
    private int invoicesId;
    private int productId;
    public requestInvoicesProduct() {
    }
    public requestInvoicesProduct(int invoicesProductId, int invoicesId, int productId) {
        this.invoicesProductId = invoicesProductId;
        this.invoicesId = invoicesId;
        this.productId = productId;
    }
    public int getInvoicesProductId() {
        return invoicesProductId;
    }
    public void setInvoicesProductId(int invoicesProductId) {
        this.invoicesProductId = invoicesProductId;
    }
    public int getInvoicesId() {
        return invoicesId;
    }
    public void setInvoicesId(int invoicesId) {
        this.invoicesId = invoicesId;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }

   
}
