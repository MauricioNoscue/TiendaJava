package com.Sena.CrudJava.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Sena.CrudJava.DTO.responseDTO;
import com.Sena.CrudJava.DTO.requestRegister.requestRegisterUserRole;
import com.Sena.CrudJava.Interface.IUserRol;
import com.Sena.CrudJava.Model.Role;
import com.Sena.CrudJava.Model.UserRole;
import com.Sena.CrudJava.Model.Users;

@Service
public class userRolService {
@Autowired
private  IUserRol userRolData;

public List<UserRole> findAll(){
    return userRolData.findAll();
}
public Optional<UserRole> findById(int id){
    return userRolData.findById(id);
}


public responseDTO save(requestRegisterUserRole userrole){
    responseDTO response = new responseDTO();
    try {
        userRolData.save(convertUserRole(userrole));
        response.setStatus(HttpStatus.OK);
        response.setMessage("userrol Guardado");
        return response;
    } catch (Exception e) {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        response.setMessage("userRol no guarado");
        return response;
    }
}


public responseDTO update(requestRegisterUserRole userroleupdate){
    responseDTO response = new responseDTO();
    var userrole = findById(userroleupdate.getUserRoleId());
    if(userrole.isPresent()){
        Role role = new Role();
        Users user = new Users();
        user.setUserId(userroleupdate.getUserId());
        role.setRoleId(userroleupdate.getRoleId());
        userrole.get().setRole(role);
        userrole.get().setUser(user);
        userRolData.save(userrole.get());
        response.setStatus(HttpStatus.OK);
        response.setMessage("userrol actualizado");
        return response;
    }else{
        response.setStatus(HttpStatus.OK);
        response.setMessage("userrol no actualizado");
        return response;
    }
}

public responseDTO Deleted(int id){
    var supplier = userRolData.findById(id);
    responseDTO response = new responseDTO();
    if(supplier.isPresent()){
        userRolData.delete(supplier.get());
        response.setStatus(HttpStatus.OK);
        response.setMessage("Se elimino correctamente");
        return response;
    }else{
        response.setStatus(HttpStatus.NOT_FOUND);
        response.setMessage("No se encontro el registro");
        return response;
    }
}

public UserRole convertUserRole(requestRegisterUserRole userrole){
    Users user = new Users();
    user.setUserId(userrole.getUserId());
    userrole.getRoleId();

    Role role = new Role();
    role.setRoleId(userrole.getRoleId());

    return new UserRole(
        0,
        user,
        role

    );
}
}
