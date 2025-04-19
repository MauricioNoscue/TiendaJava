package com.Sena.CrudJava.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sena.CrudJava.Model.Supplier;

@Repository
public interface ISupplier extends JpaRepository<Supplier, Integer> {

}
