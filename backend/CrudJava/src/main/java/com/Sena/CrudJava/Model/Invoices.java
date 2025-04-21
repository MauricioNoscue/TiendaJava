package com.Sena.CrudJava.Model;


import java.time.LocalDate;
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
    private int invoicesId;

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
  
    private Users users;
    
  

    @Column(name="Date")
    private LocalDate date;

    @OneToMany(mappedBy = "invoices", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoicesProduct> InvoicesProduct = new ArrayList<>();

    public Invoices() {
    }

    public Invoices(int invoicesId, Users users, LocalDate date,
            List<InvoicesProduct> invoicesProduct) {
        this.invoicesId = invoicesId;
        this.users = users;
        this.date = date;
        InvoicesProduct = invoicesProduct;
    }

    public int getInvoicesId() {
        return invoicesId;
    }

    public void setInvoicesId(int invoicesId) {
        this.invoicesId = invoicesId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }



    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<InvoicesProduct> getInvoicesProduct() {
        return InvoicesProduct;
    }

    public void setInvoicesProduct(List<InvoicesProduct> invoicesProduct) {
        InvoicesProduct = invoicesProduct;
    }

}
