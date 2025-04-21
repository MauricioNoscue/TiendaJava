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
import com.Sena.CrudJava.DTO.requestRegister.requestRegisterInvoices;

import com.Sena.CrudJava.Service.InvoicesService;

@RestController
@RequestMapping("api/v1/invoices")
public class invoicesController {

    @Autowired
    private InvoicesService invoicesService;

    
@GetMapping("/todo")
    public ResponseEntity<Object> finAll(){
        var invoices = invoicesService.findAllInvoices();
        return new ResponseEntity<>(invoices,HttpStatus.OK);
    }


@PostMapping("register")
    public ResponseEntity<Object> postMethodName(@RequestBody requestRegisterInvoices invoicess) {
        responseDTO userRegister = invoicesService.save(invoicess);
        return  new ResponseEntity<>(userRegister,userRegister.getStatus());
    }

    @GetMapping("ultimo")
public ResponseEntity<Object> getByIdEntity() {
   var user = invoicesService.getInvoices();
   return new ResponseEntity<>(user,HttpStatus.OK);
}

    
@PutMapping("update")
public ResponseEntity<Object> putMethodName(@RequestBody requestRegisterInvoices invoicesupdate) {

    responseDTO invoicesupd = invoicesService.update(invoicesupdate);
    return new ResponseEntity<>(invoicesupd,invoicesupd.getStatus());
    
}
@DeleteMapping("/{id}")
    public ResponseEntity<Object> DeletedPersonByI(@PathVariable int id){
        responseDTO personDeleted = invoicesService.Deleted(id);
        return new ResponseEntity<>(personDeleted,personDeleted.getStatus());
    }
}
