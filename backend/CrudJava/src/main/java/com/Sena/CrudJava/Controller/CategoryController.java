package com.Sena.CrudJava.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sena.CrudJava.DTO.responseDTO;
import com.Sena.CrudJava.DTO.requestRegister.requestRegisterCategory;
import com.Sena.CrudJava.Service.CategoryService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("api/v1/category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @GetMapping("/todo")
    public ResponseEntity<Object> finAll() {
        var category = categoryService.findAll();
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> finAllById(@PathVariable int id) {
        var category = categoryService.findById(id);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<Object> postMethodName(@RequestBody requestRegisterCategory category) {
       
        responseDTO categpryRegister = categoryService.save(category);
        return new ResponseEntity<>(categpryRegister,categpryRegister.getStatus());
    }
    
    @PutMapping("update")
    public ResponseEntity<Object> putMethodName( @RequestBody requestRegisterCategory category) {
              
        responseDTO categoryupdate = categoryService.update(category);
        
        return new ResponseEntity<>(categoryupdate,categoryupdate.getStatus());
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> DeletedPersonByI(@PathVariable int id){
        responseDTO categprydeleted = categoryService.deleted(id);
        return new ResponseEntity<>(categprydeleted,categprydeleted.getStatus());
    }
    
    
}
