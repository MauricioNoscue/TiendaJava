package com.Sena.CrudJava.DTO.requestRegister;

import java.time.LocalDate;


public class requestRegisterInvoices {

    private int invoicesId;
    private int userId; // Se usa el ID en lugar del objeto completo

    private LocalDate date;
   

    public requestRegisterInvoices() {
    }

    public requestRegisterInvoices(int invoicesId, int userId, LocalDate date) {
        this.invoicesId = invoicesId;
        this.userId = userId;
    
        this.date = date;
      
    }

    public int getInvoicesId() {
        return invoicesId;
    }

    public void setInvoicesId(int invoicesId) {
        this.invoicesId = invoicesId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

 

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

  

}
