package com.Sena.CrudJava.DTO.responseDTo;

import java.sql.Date;

public class ResponseInvoicesProduct {
    private int invoicesId;
    private Date date;
    private int productId;
    private String productName;
    private double productPrice;
    private String userName;

    public ResponseInvoicesProduct() {
    }

    public ResponseInvoicesProduct(int invoicesId, Date date, int productId, String productName, double productPrice, String userName) {
        this.invoicesId = invoicesId;
        this.date = date;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.userName = userName;
    }

    public int getInvoicesId() {
        return invoicesId;
    }

    public void setInvoicesId(int invoicesId) {
        this.invoicesId = invoicesId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}