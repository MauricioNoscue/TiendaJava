package com.Sena.CrudJava.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Sena.CrudJava.Model.Product;

@Repository
public interface IProduct extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM product WHERE LOWER(product_name) LIKE LOWER(CONCAT('%', :nombre, '%'))", nativeQuery = true)
List<Product> buscarPorNombreLike(@Param("nombre") String nombre);

}
