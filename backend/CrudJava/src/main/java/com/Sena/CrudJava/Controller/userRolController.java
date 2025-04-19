package com.Sena.CrudJava.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sena.CrudJava.DTO.responseDTO;
import com.Sena.CrudJava.DTO.requestRegister.requestRegisterUserRole;
import com.Sena.CrudJava.Service.userRolService;

@RestController
@RequestMapping("api/v1/userRol")
public class userRolController {

    @Autowired
    private userRolService userRolService;

@GetMapping("/todo")
    public ResponseEntity<Object> finAllPer(){
        var Users = userRolService.findAll();
        return new ResponseEntity<>(Users,HttpStatus.OK);
    }


    @PostMapping("register")
    public ResponseEntity<Object> postMethodName(@RequestBody requestRegisterUserRole userr) {
        responseDTO userRegister = userRolService.save(userr);
        return  new ResponseEntity<>(userRegister,userRegister.getStatus());
    }

@PutMapping("update")
public ResponseEntity<Object> putMethodName(@RequestBody requestRegisterUserRole userUpdate) {

    responseDTO userUpd = userRolService.update(userUpdate);
    return new ResponseEntity<>(userUpd,userUpd.getStatus());
    
}
}
