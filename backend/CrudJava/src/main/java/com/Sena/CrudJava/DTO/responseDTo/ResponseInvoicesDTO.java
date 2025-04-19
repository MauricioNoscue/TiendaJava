package com.Sena.CrudJava.DTO.responseDTo;

import java.time.LocalDate;

public class ResponseInvoicesDTO {
    private int invoicesId;
    private int userId;
    private String nameInvoices;
    private LocalDate date;

    public ResponseInvoicesDTO() {
    }

    public ResponseInvoicesDTO(int invoicesId, int userId, String nameInvoices, LocalDate date) {
        this.invoicesId = invoicesId;
        this.userId = userId;
        this.nameInvoices = nameInvoices;
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

    public String getNameInvoices() {
        return nameInvoices;
    }

    public void setNameInvoices(String nameInvoices) {
        this.nameInvoices = nameInvoices;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}