package com.Sena.CrudJava.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity(name ="InvoicesProduct")

public class InvoicesProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InvoicesProductId")
    private int InvoicesProductId;

    @Column(name = "cantidad")
    private int cantidad;

    public InvoicesProduct() {
    }

    public InvoicesProduct(int invoicesProductId, int cantidad, Invoices invoices, Product product) {
        InvoicesProductId = invoicesProductId;
        this.cantidad = cantidad;
        this.invoices = invoices;
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "invoicesId", referencedColumnName = "InvoicesId", nullable = false)
    private Invoices invoices;

    @ManyToOne
    @JoinColumn(name = "product", referencedColumnName = "ProductId", nullable = false)
    private Product product;

    public int getInvoicesProductId() {
        return InvoicesProductId;
    }

    public void setInvoicesProductId(int invoicesProductId) {
        InvoicesProductId = invoicesProductId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Invoices getInvoices() {
        return invoices;
    }

    public void setInvoices(Invoices invoices) {
        this.invoices = invoices;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
