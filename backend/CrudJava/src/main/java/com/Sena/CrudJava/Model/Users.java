package com.Sena.CrudJava.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name ="Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;

    @Column(name= "UserName",length = 255, nullable = false,unique = true)
    private String userName;
    @Column(name = "Password",length = 255, nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name = "personId", referencedColumnName = "personId")
    private Person person;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
 
    private List<UserRole> userRoles = new ArrayList<>();
        
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoices> Invoices = new ArrayList<>();

    public int getUserId() {
        return userId;
    }

    public Users(int userId, String userName, String password, Person person) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.person = person;
    }

    public Users() {
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
