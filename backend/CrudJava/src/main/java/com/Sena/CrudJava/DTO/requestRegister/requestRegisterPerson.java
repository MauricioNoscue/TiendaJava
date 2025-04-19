package com.Sena.CrudJava.DTO.requestRegister;

public class requestRegisterPerson {

    private int personId;
    private String personName;
    private String lastName;
    private String email;
    private String phone;
    public requestRegisterPerson(int personId, String personName, String lastName, String email, String phone) {
        this.personId = personId;
        this.personName = personName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
    public int getPersonId() {
        return personId;
    }
    public void setPersonId(int personId) {
        this.personId = personId;
    }
    public String getPersonName() {
        return personName;
    }
    public void setPersonName(String personName) {
        this.personName = personName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}

