package com.Sena.CrudJava.DTO.responseDTo;

import java.time.LocalDate;

public class ResponseInvoicesDTO {
    private int invoicesId;
    private int userId;

    private LocalDate date;

    public ResponseInvoicesDTO() {
    }

    public ResponseInvoicesDTO(int invoicesId, int userId,  LocalDate date) {
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