package com.Sena.CrudJava.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sena.CrudJava.Model.Role;

@Repository
public interface IRole  extends  JpaRepository<Role, Integer>{

}
