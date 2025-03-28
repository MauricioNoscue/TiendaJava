package com.Sena.CrudJava.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity(name = "ProductSupplier")
public class ProductSupplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductSupplierId")
    private int productSupplierId;

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "ProductId", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "supplierId", referencedColumnName = "SupplierId", nullable = false)
    private Supplier supplier;

    public ProductSupplier() {
    }

    public ProductSupplier(int productSupplierId, Product product, Supplier supplier) {
        this.productSupplierId = productSupplierId;
        this.product = product;
        this.supplier = supplier;
    }

    public int getProductSupplierId() {
        return productSupplierId;
    }

    public void setProductSupplierId(int productSupplierId) {
        this.productSupplierId = productSupplierId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
