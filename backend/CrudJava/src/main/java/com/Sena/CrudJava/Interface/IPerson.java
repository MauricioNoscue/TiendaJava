package com.Sena.CrudJava.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sena.CrudJava.Model.Person;
@Repository
public interface IPerson extends JpaRepository<Person,Integer>{

}
