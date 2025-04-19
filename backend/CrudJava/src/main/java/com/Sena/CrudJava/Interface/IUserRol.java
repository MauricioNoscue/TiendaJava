package com.Sena.CrudJava.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sena.CrudJava.Model.UserRole;

@Repository
public interface IUserRol extends JpaRepository<UserRole,Integer> {

}
