package com.Sena.CrudJava.Controller;

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
import com.Sena.CrudJava.DTO.requestRegister.requestRegisterSupplier;
import com.Sena.CrudJava.Service.supplierService;

@RestController
@RequestMapping("api/v1/supplier")
public class SupplierController {

    @Autowired
    private supplierService supplierService;
    
    @GetMapping("/todo")
    public ResponseEntity<Object> finAllPer(){
        var suppliers = supplierService.finAllSupplier();
        return new ResponseEntity<>(suppliers,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> FinByIdPersona(@PathVariable  int id){
        var supplier = supplierService.finByIdSupplier(id);
        return  new ResponseEntity<>(supplier,HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<Object> postMethodName(@RequestBody requestRegisterSupplier supplierr) {
        responseDTO supplierregister = supplierService.save(supplierr);
        return  new ResponseEntity<>(supplierregister,supplierregister.getStatus());
    }

    @PutMapping("update")
public ResponseEntity<Object> putMethodName(@RequestBody requestRegisterSupplier supplierupdate) {
    responseDTO supplierud = supplierService.update(supplierupdate);
    return new ResponseEntity<>(supplierud,supplierud.getStatus());
    
}


@DeleteMapping("/{id}")
    public ResponseEntity<Object> DeletedPersonByI(@PathVariable int id){
        responseDTO supplierdeleted = supplierService.Deleted(id);
        return new ResponseEntity<>(supplierdeleted,supplierdeleted.getStatus());
    }

}
