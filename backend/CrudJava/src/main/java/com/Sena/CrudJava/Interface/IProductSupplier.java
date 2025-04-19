package com.Sena.CrudJava.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Sena.CrudJava.DTO.responseDTo.ResponseProductSupplier;
import com.Sena.CrudJava.Model.ProductSupplier;

@Repository
public interface IProductSupplier extends JpaRepository<ProductSupplier,Integer> {

    
    @Query(value = """
      SELECT p.product_id AS productId,
           p.product_name AS productName,
           s.supplier_id AS supplierId,
           s.supplier_name AS supplierName
    FROM product_supplier ps
    INNER JOIN product p ON ps.product_id = p.product_id
    INNER JOIN supplier s ON ps.supplier_id = s.supplier_id
    """, nativeQuery = true)
    List<ResponseProductSupplier> findAllProductSupplierInfo();


    @Query(value = """
    SELECT p.product_id AS productId,
           p.product_name AS productName,
           s.supplier_id AS supplierId,
           s.supplier_name AS supplierName
    FROM product_supplier ps
    INNER JOIN product p ON ps.product_id = p.product_id
    INNER JOIN supplier s ON ps.supplier_id = s.supplier_id
    WHERE ps.product_supplier_id = :id
    """, nativeQuery = true)
    ResponseProductSupplier findProductSupplierInfoById(@Param("id") int id);

}
