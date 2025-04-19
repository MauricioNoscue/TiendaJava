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
import com.Sena.CrudJava.DTO.requestRegister.requestRegisterRole;
import com.Sena.CrudJava.Service.roleService;


@RestController
@RequestMapping("api/v1/role")
public class RoleController {
@Autowired
private roleService roleService;


@GetMapping("/todo")
    public ResponseEntity<Object> finAllPer(){
        var Users = roleService.finAll();
        return new ResponseEntity<>(Users,HttpStatus.OK);
    }
@GetMapping("/{id}")
public ResponseEntity<Object> getByIdEntity(@PathVariable int id) {
    var role = roleService.finById(id);
    return new ResponseEntity<>(role, HttpStatus.OK);
}


    
@PostMapping("register")
    public ResponseEntity<Object> postMethodName(@RequestBody requestRegisterRole role) {
        responseDTO roleegister = roleService.save(role);
        return  new ResponseEntity<>(roleegister,roleegister.getStatus());
    }


@PutMapping("update")
public ResponseEntity<Object> putMethodName(@RequestBody requestRegisterRole roleupdate) {

    responseDTO roleupdated = roleService.update(roleupdate);
    return new ResponseEntity<>(roleupdated,roleupdated.getStatus());
    
}

@DeleteMapping("/{id}")
    public ResponseEntity<Object> DeletedPersonByI(@PathVariable int id){
        responseDTO roleDeleted = roleService.deleted(id);
        return new ResponseEntity<>(roleDeleted,roleDeleted.getStatus());
    }



}
