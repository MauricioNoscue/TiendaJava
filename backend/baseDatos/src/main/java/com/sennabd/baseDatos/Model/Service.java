package com.sennabd.baseDatos.Model;

import jakarta.persistence.*;

@Entity(name="Service")
public class Service {
    @Id
    @Column(name="id_service",length = 10,nullable=false)
    private int id_service;
    @Column(name="name_service",length = 50,nullable=false)
    private String name_service;
    @Column(name="description_service",length = 100,nullable=false)
    private String description_service;


}
