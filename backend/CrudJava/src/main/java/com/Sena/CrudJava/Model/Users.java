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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name ="Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private int UserId;

    @Column(name= "UserName",length = 255, nullable = false,unique = true)
    private String UserName;
    @Column(name = "Password",length = 255, nullable = false)
    private String Password;

    @OneToOne
    @JoinColumn(name = "personId", referencedColumnName = "personId")
    private Person person;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserRole> userRoles = new ArrayList<>();
        
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoices> Invoices = new ArrayList<>();

    public int getUserId() {
        return UserId;
    }

    public Users(int userId, String userName, String password, Person person) {
        UserId = userId;
        UserName = userName;
        Password = password;
        this.person = person;
    }

    public Users() {
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
