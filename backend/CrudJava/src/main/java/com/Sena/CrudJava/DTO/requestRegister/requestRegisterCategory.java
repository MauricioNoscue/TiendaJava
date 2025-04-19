package com.Sena.CrudJava.DTO.requestRegister;

public class requestRegisterCategory {
    private int categoryId;
    private String name;

    public requestRegisterCategory() {
    }

    public requestRegisterCategory(int categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
