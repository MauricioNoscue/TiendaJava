package com.Sena.CrudJava.DTO;

public class loginDTo {
    private String username;
    private String password;
    public loginDTo() {
    }
    public loginDTo(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUserName() {
        return username;
    }
    public void setUserName(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
