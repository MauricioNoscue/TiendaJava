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

    @ManyToOne
    @JoinColumn(name = "invoicesId", referencedColumnName = "InvoicesId", nullable = false)
    private Invoices invoices;

    @ManyToOne
    @JoinColumn(name = "product", referencedColumnName = "ProductId", nullable = false)
    private Product product;


    public InvoicesProduct() {
    }

    public InvoicesProduct(int invoicesProductId,  Invoices invoices, Product product) {
        InvoicesProductId = invoicesProductId;
        this.invoices = invoices;
        this.product = product;
    }

    public int getInvoicesProductId() {
        return InvoicesProductId;
    }

    public void setInvoicesProductId(int invoicesProductId) {
        InvoicesProductId = invoicesProductId;
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
