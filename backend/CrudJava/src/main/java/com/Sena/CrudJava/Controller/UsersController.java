package com.Sena.CrudJava.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Sena.CrudJava.DTO.loginDTo;
import com.Sena.CrudJava.DTO.responseDTO;
import com.Sena.CrudJava.DTO.requestRegister.requestRegisterUser;
import com.Sena.CrudJava.Interface.IUser;
import com.Sena.CrudJava.Model.Users;
import com.Sena.CrudJava.Service.UserService;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/v1/Users")
public class UsersController {
@Autowired
private UserService userService;

@Autowired
private IUser userDataa;

@GetMapping("/todo")
    public ResponseEntity<Object> finAllPer(){
        var Users = userService.finALlUser();
        return new ResponseEntity<>(Users,HttpStatus.OK);
    }


@GetMapping("/{id}")
public ResponseEntity<Object> getByIdEntity(@PathVariable int id) {
   var user = userService.finByIdUser(id);
   return new ResponseEntity<>(user,HttpStatus.OK);
}

@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody loginDTo login) {
    List<Users> users = userDataa.findAll(); // trae todos los usuarios

    Optional<Users> userFound = users.stream()
        .filter(u -> u.getUserName().equals(login.getUserName()) &&
                     u.getPassword().equals(login.getPassword()))
        .findFirst();

    if (userFound.isPresent()) {
        return ResponseEntity.ok(userFound.get()); // login exitoso
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrectos");
    }
}


@GetMapping("ultimaPersona")
public ResponseEntity<Object> getByIdEntity() {
   var user = userService.getLastPersonId();
   return new ResponseEntity<>(user,HttpStatus.OK);
}

@PostMapping("register")
    public ResponseEntity<Object> postMethodName(@RequestBody requestRegisterUser userr) {
        responseDTO userRegister = userService.save(userr);
        return  new ResponseEntity<>(userRegister,userRegister.getStatus());
    }

@PutMapping("update")
public ResponseEntity<Object> putMethodName(@RequestBody requestRegisterUser userUpdate) {

    responseDTO userUpd = userService.update(userUpdate);
    return new ResponseEntity<>(userUpd,userUpd.getStatus());
    
}

@DeleteMapping("/{id}")
    public ResponseEntity<Object> DeletedPersonByI(@PathVariable int id){
        responseDTO personDeleted = userService.DeleteUser(id);
        return new ResponseEntity<>(personDeleted,personDeleted.getStatus());
    }
}
