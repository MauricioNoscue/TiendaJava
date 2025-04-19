package com.Sena.CrudJava.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sena.CrudJava.Model.Product;

@Repository
public interface IProduct extends JpaRepository<Product, Integer> {

    
}
