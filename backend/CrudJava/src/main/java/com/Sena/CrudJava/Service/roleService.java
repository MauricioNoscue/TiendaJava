package com.Sena.CrudJava.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.Sena.CrudJava.DTO.responseDTO;
import com.Sena.CrudJava.DTO.requestRegister.requestRegisterRole;
import com.Sena.CrudJava.Interface.IRole;
import com.Sena.CrudJava.Model.Role;

@Service
public class roleService {
    @Autowired
    private IRole roleData;

    public List<Role> finAll(){
        return roleData.findAll();
    }
    public Optional<Role> finById(int id){
        return roleData.findById(id);
    }

    public responseDTO save(requestRegisterRole rol){
        responseDTO response = new responseDTO();
        try {
            roleData.save(convertRegisteRole(rol));
            response.setStatus(HttpStatus.OK);
            response.setMessage("Supplier saved");
            return response;
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("Supplier  no guardado");
            return response;
        }
    }

    public responseDTO update(@RequestBody requestRegisterRole roleupdate){
        
        var role = roleData.findById(roleupdate.getRoleId());
        
        responseDTO response = new responseDTO();
        if(role.isPresent()){
            role.get().setRoleName(roleupdate.getRoleName());
            roleData.save(role.get());
            response.setStatus(HttpStatus.OK);
            response.setMessage("Rol actualizado con exito");
            return response;
        }else{
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("Rol no actualizado");
            return response;
        }
    }

    public responseDTO deleted(int id){
        responseDTO response = new responseDTO();
        var roledelted = finById(id);
        if (roledelted.isPresent()) {
            roleData.delete(roledelted.get());
            response.setStatus(HttpStatus.OK);
            response.setMessage("Rol eliminado con exito");
            return response;
        }else{
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("Rol no eliminado");
            return response;
        }
    }

    public Role convertRegisteRole(requestRegisterRole role){
        return new Role(
            0,
            role.getRoleName(),
            null
            
        );
    }


}
