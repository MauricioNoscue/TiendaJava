package com.Sena.CrudJava.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sena.CrudJava.DTO.responseDTO;
import com.Sena.CrudJava.DTO.requestRegister.requestRegisterProductSupplier;
import com.Sena.CrudJava.Service.ProductSupplierService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1/productSupplier")
public class ProductSupplierController {

    @Autowired
    private ProductSupplierService productSupplierService;

    @GetMapping("/todo")
    public ResponseEntity<Object> finAll(){
        var productSupplierr = productSupplierService.getProductSupplierInfo();
        return new ResponseEntity<>(productSupplierr,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getByIdEntity(@PathVariable int id) {
    var productSupplier = productSupplierService.getProductSupplierInfoById(id);
    return new ResponseEntity<>(productSupplier,HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<Object> postMethodName(@RequestBody requestRegisterProductSupplier productSupplier) {
        var productSuppliercreated = productSupplierService.save(productSupplier);
        return new ResponseEntity<>(productSuppliercreated,productSuppliercreated.getStatus());
    }
    @PutMapping("update")
public ResponseEntity<Object> putMethodName(@RequestBody requestRegisterProductSupplier userUpdate) {

    responseDTO userUpd = productSupplierService.update(userUpdate);
    return new ResponseEntity<>(userUpd,userUpd.getStatus());
    
}

@DeleteMapping("/{id}")
    public ResponseEntity<Object> DeletedPersonByI(@PathVariable int id){
        responseDTO personDeleted = productSupplierService.Deleted(id);
        return new ResponseEntity<>(personDeleted,personDeleted.getStatus());
    }
    
}
