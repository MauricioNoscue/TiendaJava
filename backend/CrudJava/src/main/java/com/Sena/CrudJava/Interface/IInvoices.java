package com.Sena.CrudJava.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sena.CrudJava.Model.Invoices;

@Repository
public interface IInvoices extends JpaRepository<Invoices, Integer> {

}
