package com.Sena.CrudJava.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Sena.CrudJava.DTO.responseDTo.ResponseInvoicesProduct;
import com.Sena.CrudJava.Model.InvoicesProduct;

@Repository
public interface IInvoicesProduct extends JpaRepository<InvoicesProduct,Integer> {

       @Query(value = """
              SELECT 
                  s.invoices_id AS invoicesId,
                  s.date AS date,
                  p.product_id AS productId,
                  p.product_name AS productName,
				  p.product_price AS productPrice,
                  u.user_name AS userName
              FROM invoices_product ps
              INNER JOIN product p ON ps.product = p.product_id
              INNER JOIN invoices s ON ps.invoices_id = s.invoices_id
              INNER JOIN users u ON s.user_id = u.user_id
          """, nativeQuery = true)
          List<ResponseInvoicesProduct> findAllProductinvoicesInfo();
          


    @Query(value = """
    SELECT p.product_id AS productId,
           p.product_name AS productName,
           s.invoices_id AS invoicesId
          
    FROM invoices_product ps
    INNER JOIN product p ON ps.product= p.product_id
    INNER JOIN invoices s ON ps.invoices_id = s.invoices_id
    WHERE ps.invoices_product_id = :id
    """, nativeQuery = true)
    ResponseInvoicesProduct findProductinvoicesInfoById(@Param("id") int id);
}
