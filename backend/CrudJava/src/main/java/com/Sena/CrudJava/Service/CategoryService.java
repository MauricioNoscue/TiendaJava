package com.Sena.CrudJava.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Sena.CrudJava.DTO.responseDTO;
import com.Sena.CrudJava.DTO.requestRegister.requestRegisterCategory;
import com.Sena.CrudJava.Interface.ICategory;
import com.Sena.CrudJava.Model.Category;


@Service
public class CategoryService {

    @Autowired
    private ICategory categoryData;

    public List<Category> findAll(){
        return categoryData.findAll();
    }

    public Optional<Category> findById(int id ){
        return categoryData.findById(id);
    }

    public responseDTO save(requestRegisterCategory category){
        responseDTO response = new responseDTO();
        try {
            categoryData.save(convertRegisCategory(category));
            response.setStatus(HttpStatus.OK);
            response.setMessage("categoria creada con exito");
            return response;
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("categoria no  creada con exito");
            return response;
        }
    }

    public responseDTO update(requestRegisterCategory categoryupdate){
        responseDTO response = new responseDTO();
        var category = categoryData.findById(categoryupdate.getCategoryId());
        if(category.isPresent()){
            category.get().setName(categoryupdate.getName());
            categoryData.save(category.get());
            response.setStatus(HttpStatus.OK);
            response.setMessage("categoria actualizada con exito");
            return response;
        }else{
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("categoria no encontrada"); 
            return response;
        }
    }

    public responseDTO deleted(int id ){
        responseDTO response = new responseDTO();
        var category = categoryData.findById(id);
        if(category.isPresent()){
            categoryData.delete(category.get());
            response.setStatus(HttpStatus.OK);
            response.setMessage("categoria eliminada con exito");
            return response;

        }else{
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("categoria no encontrada");
            return response;
        }
    }

    public Category convertRegisCategory(requestRegisterCategory category){
        return new Category(
            0,
            category.getName(),
            null
        );
    }

}
