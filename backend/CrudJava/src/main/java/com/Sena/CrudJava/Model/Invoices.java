package com.Sena.CrudJava.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "Invoices")
public class Invoices {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="InvoicesId")
    private int InvoicesId;
    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    private Users users;
    
    @OneToMany(mappedBy = "invoices", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoicesProduct> InvoicesProduct = new ArrayList<>();

    public Invoices() {
    }

    public Invoices(int invoicesId, Users users, List<com.Sena.CrudJava.Model.InvoicesProduct> invoicesProduct) {
        InvoicesId = invoicesId;
        this.users = users;
        InvoicesProduct = invoicesProduct;
    }

    public int getInvoicesId() {
        return InvoicesId;
    }

    public void setInvoicesId(int invoicesId) {
        InvoicesId = invoicesId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<InvoicesProduct> getInvoicesProduct() {
        return InvoicesProduct;
    }

    public void setInvoicesProduct(List<InvoicesProduct> invoicesProduct) {
        InvoicesProduct = invoicesProduct;
    }

}
