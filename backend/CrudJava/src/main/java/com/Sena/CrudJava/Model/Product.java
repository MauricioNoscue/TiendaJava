package com.Sena.CrudJava.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name ="Product" )
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private int ProductId;
    @Column(name = "productName",length = 255, nullable = false)
    private String productName;
    @Column(name = "description",columnDefinition = "TEXT")
    private String description;
    @Column(name = "productPrice")
    private double productPrice;
    @OneToMany(mappedBy  = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ProductSupplier> productSupplier = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    @JsonIgnoreProperties("products")
    private Category category;
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
   
    private List<InvoicesProduct> InvoicesProduct = new ArrayList<>();

    public Product() {
    }
    public Product(int productId, String productName, String description, double productPrice, Category category,
            List<ProductSupplier> productSupplier) {
        ProductId = productId;
        this.productName = productName;
        this.description = description;
        this.productPrice = productPrice;
        this.category = category;
        this.productSupplier = productSupplier;
    }
    public int getProductId() {
        return ProductId;
    }
    public void setProductId(int productId) {
        ProductId = productId;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    public List<ProductSupplier> getProductSupplier() {
        return productSupplier;
    }
    public void setProductSupplier(List<ProductSupplier> productSupplier) {
        this.productSupplier = productSupplier;
    }
    
}   
