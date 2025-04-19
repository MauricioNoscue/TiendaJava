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
import com.Sena.CrudJava.DTO.requestRegister.requestInvoicesProduct;
import com.Sena.CrudJava.Service.InvoicesProductService;

@RestController
@RequestMapping("api/v1/invoicesProduct")
public class InvoiceProductController {

    @Autowired
    private InvoicesProductService invoicesProductService;


    @GetMapping("/todo")
    public ResponseEntity<Object> finAllPer(){
        var Users = invoicesProductService.getProductSupplierInfo();
        return new ResponseEntity<>(Users,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getByIdEntity(@PathVariable int id) {
    var user = invoicesProductService.getProductSupplierInfoById(id);
    return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("register")
        public ResponseEntity<Object> postMethodName(@RequestBody requestInvoicesProduct userr) {
            responseDTO userRegister = invoicesProductService.save(userr);
            return  new ResponseEntity<>(userRegister,userRegister.getStatus());
        }

    @PutMapping("update")
    public ResponseEntity<Object> putMethodName(@RequestBody requestInvoicesProduct userUpdate) {

        responseDTO userUpd = invoicesProductService.update(userUpdate);
        return new ResponseEntity<>(userUpd,userUpd.getStatus());
        
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> DeletedPersonByI(@PathVariable int id){
        responseDTO personDeleted = invoicesProductService.Deleted(id);
        return new ResponseEntity<>(personDeleted,personDeleted.getStatus());
    }

}
