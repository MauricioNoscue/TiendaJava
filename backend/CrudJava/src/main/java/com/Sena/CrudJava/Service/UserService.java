package com.Sena.CrudJava.Service;

import com.Sena.CrudJava.DTO.Idperson;
import com.Sena.CrudJava.DTO.responseDTO;
import com.Sena.CrudJava.DTO.requestRegister.requestRegisterUser;
import com.Sena.CrudJava.Interface.IUser;
import com.Sena.CrudJava.Model.Users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService   {

    
  @Autowired
  private IUser userData;

  public List<Users> finALlUser(){
    return userData.findAll();
  }

  public Optional<Users> finByIdUser(int id){
    return userData.findById(id);
  }
 public Idperson getLastPersonId() {
    return userData.traerPersona(); 
  }

  public requestRegisterUser login(String userName, String password) {
    return userData.login(userName, password);
  }

  public responseDTO save(requestRegisterUser user){
    responseDTO response = new responseDTO();
    try {
        userData.save(convertRegisterUser(user));
        response.setStatus(HttpStatus.OK);
        response.setMessage("Usuario registrado ");
        return response;

    } catch (Exception e) {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        response.setMessage("Usuario no registrado por un error");
        return response;
    }
  }

  public responseDTO update( requestRegisterUser user){
    responseDTO response = new responseDTO();
    try {
        var userupddate = finByIdUser(user.getUserId());
        if(userupddate.isPresent()){
            userupddate.get().setUserName(user.getUserName());
            userupddate.get().setPassword(user.getPassword());
            userupddate.get().setPerson(user.getPerson());
            userData.save(userupddate.get());
            response.setStatus(HttpStatus.OK);
            response.setMessage("Usuario actualizado"); 
        }
        return response;
    } catch (Exception e) {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("Usuario no actualizado");
            return response;
    }
  }


  public responseDTO DeleteUser(int id){
    var userDeleted = finByIdUser(id);
    responseDTO response = new responseDTO();
    if(userDeleted.isPresent()){
        userData.delete(userDeleted.get());
        response.setStatus(HttpStatus.OK);
        response.setMessage("Usuario eliminado"); 
        return response;
    }else{
        response.setStatus(HttpStatus.NOT_FOUND);
        response.setMessage("Usuario no eliminado"); 
        return response;

    }
  }

    public Users convertRegisterUser(requestRegisterUser user){
        System.out.println("Password recibido: " + user.getPassword());
        return new Users(
                0,
                user.getUserName(),
                user.getPassword(),
                user.getPerson()

        );
    }
    


}
