package com.Sena.CrudJava.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Sena.CrudJava.DTO.idInvoices;
import com.Sena.CrudJava.Model.Invoices;

@Repository
public interface IInvoices extends JpaRepository<Invoices, Integer> {

    @Query(value = """
        SELECT invoices_id
    FROM invoices
    ORDER BY invoices_id DESC
    LIMIT 1;
    """, nativeQuery = true)
    idInvoices traerInvoices();

}
