package com.Sena.CrudJava.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sena.CrudJava.DTO.responseDTO;
import com.Sena.CrudJava.DTO.requestRegister.requesRegisterProduct;

import com.Sena.CrudJava.Service.productService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/v1/product")
public class productController {

    @Autowired
    private productService productService;

    @GetMapping("/todo")
    public ResponseEntity<Object> finAllPer(){
        var product = productService.finAll();
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @GetMapping("/{id}")
public ResponseEntity<Object> getByIdEntity(@PathVariable int id) {
   var product = productService.finById(id);
   return new ResponseEntity<>(product,HttpStatus.OK);
}
@GetMapping("buscar")
public ResponseEntity<List<requesRegisterProduct>> getMethodName(@RequestParam String name) {
    List<requesRegisterProduct> productos = productService.buscar(name);
    return ResponseEntity.ok(productos);
}


    @PostMapping("register")
    public ResponseEntity<Object> postMethodName(@RequestBody requesRegisterProduct productt) {
        responseDTO producttegister = productService.save(productt);
        return  new ResponseEntity<>(producttegister,producttegister.getStatus());
    }

    @PutMapping("update")
public ResponseEntity<Object> putMethodName(@RequestBody requesRegisterProduct productupdate) {

    responseDTO producto = productService.update(productupdate);
    return new ResponseEntity<>(producto,producto.getStatus());
    
}

@DeleteMapping("/{id}")
    public ResponseEntity<Object> DeletedPersonByI(@PathVariable int id){
        responseDTO productdeleted = productService.Deleted(id);
        return new ResponseEntity<>(productdeleted,productdeleted.getStatus());
    }
}
