package com.Sena.CrudJava.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Sena.CrudJava.DTO.IdSupplier;
import com.Sena.CrudJava.Model.Supplier;

@Repository
public interface ISupplier extends JpaRepository<Supplier, Integer> {


    
    @Query(value = """
        SELECT supplier_id
    FROM supplier
    ORDER BY supplier_id DESC
    LIMIT 1;
    """, nativeQuery = true)
    IdSupplier traerSupplier();

}
