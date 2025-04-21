package com.Sena.CrudJava.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Sena.CrudJava.DTO.responseDTO;
import com.Sena.CrudJava.DTO.requestRegister.requestRegisterPerson;
import com.Sena.CrudJava.Service.PersonService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("api/v1/person")
public class PersonController {
    @Autowired
    private PersonService personService;


    @GetMapping("/todo")
    public ResponseEntity<Object> finAllPer(){
        var personas = personService.finAllPerson();
        return new ResponseEntity<>(personas,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> FinByIdPersona(@PathVariable  int id){
        var Persona = personService.findByIdPerson(id);
        return  new ResponseEntity<>(Persona,HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<Object> postMethodName(@RequestBody requestRegisterPerson person) {
        responseDTO response = personService.save(person);
        return new ResponseEntity<>(response,response.getStatus());
    } 
    @PutMapping("update")
    public ResponseEntity<Object> putMethodName( @RequestBody requestRegisterPerson person) {
       responseDTO response = personService.update(person);
      return new ResponseEntity<>(response,response.getStatus());
        
        
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> DeletedPersonByI(@PathVariable int id){
        responseDTO personDeleted = personService.DeletedPersonById(id);
        return new ResponseEntity<>(personDeleted,personDeleted.getStatus());
    }
}
