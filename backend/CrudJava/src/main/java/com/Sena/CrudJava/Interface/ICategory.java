package com.Sena.CrudJava.Interface;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sena.CrudJava.Model.Category;

@Repository
public interface ICategory extends JpaRepository<Category,Integer>{

}
