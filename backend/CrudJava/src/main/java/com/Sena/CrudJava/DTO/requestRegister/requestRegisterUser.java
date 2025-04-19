package com.Sena.CrudJava.DTO.requestRegister;

import com.Sena.CrudJava.Model.Person;

public class requestRegisterUser {

    private  int userId;
    private  String userName;
    private  String password;
    private Person person;

    public requestRegisterUser() {
    }

    public requestRegisterUser(int userId, String userName, String password, Person person) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.person = person;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

  
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

   

 
}
