package com.Sena.CrudJava.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

// anotacion bean indica que la clase sea una entidad 
@Entity(name = "Person")
public class Person {
    // pk
    @Id
    // valor auto incrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // colummna de la tabla
    @Column(name = "personId")
    private int personId;

    @Column(name = "PersonName", length = 120, nullable = false)
    private String personName;
    @Column(name = "LastName", length = 120, nullable = false)
    private String lastName;
    @Column(name = "Email", length = 100)
    private String Email;
    @Column(name = "Phone", length = 100)
    private String Phone;

    public Person() {
    }

    public Person(int personId, String personName, String lastName, String email, String phone) {
        this.personId = personId;
        this.personName = personName;
        this.lastName = lastName;
        Email = email;
        Phone = phone;
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
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @OneToOne(mappedBy = "person")
    private Users user;

}
