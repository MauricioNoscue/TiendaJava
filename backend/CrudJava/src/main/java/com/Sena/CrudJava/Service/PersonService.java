package com.Sena.CrudJava.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Sena.CrudJava.DTO.responseDTO;
import com.Sena.CrudJava.DTO.requestRegister.requestRegisterPerson;
import com.Sena.CrudJava.Interface.IPerson;
import com.Sena.CrudJava.Model.Person;

@Service
public class PersonService {

    @Autowired
    private IPerson personData;

    public List<Person> finAllPerson(){
        return personData.findAll();
    }

    public Optional<Person> findByIdPerson(int id){
        return personData.findById(id);
    }

    public responseDTO save(requestRegisterPerson person){
        responseDTO response = new responseDTO();
        try {
            personData.save(convertRegisterPerson(person));
            response.setStatus(HttpStatus.OK);
            response.setMessage("persona creada "); 
            return response;
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("persona  no creada "); 
            return response;
        }
    }

    public responseDTO update(requestRegisterPerson personUdape){
        responseDTO response = new responseDTO();
       try {
        var person = findByIdPerson(personUdape.getPersonId());
        if(person.isPresent()){
            person.get().setPersonName(personUdape.getPersonName());
            person.get().setLastName(personUdape.getLastName());
            person.get().setEmail(personUdape.getEmail());
            person.get().setPhone(personUdape.getPhone());
            personData.save(person.get());
            response.setStatus(HttpStatus.OK);
            response.setMessage("persona actualizada"); 
        }
        return response;
       } catch (Exception e) {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        response.setMessage("persona  no actualizada "); 
        return response;

       }
    }

    public Person convertRegisterPerson(requestRegisterPerson person){
        return new Person(
                0,
                person.getPersonName(),
                person.getLastName(),
                person.getEmail(),
                person.getPhone()

        );
    }

    public responseDTO DeletedPersonById(int id){
        var personDeleted  =  personData.findById(id);
        responseDTO response = new responseDTO();
        if(personDeleted.isPresent()){
            personData.delete(personDeleted.get());
            response.setStatus(HttpStatus.OK);
            response.setMessage("Se elimino correctamente");
            return response;
        }else{
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("No se encontro el registro");
            return response;
        }
    }

}
