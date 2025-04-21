package com.Sena.CrudJava.Interface;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Sena.CrudJava.DTO.Idperson;
import com.Sena.CrudJava.DTO.requestRegister.requestRegisterUser;
import com.Sena.CrudJava.Model.Users;

@Repository
public interface IUser extends JpaRepository<Users, Integer>{

    @Query(value = """
        SELECT person_id
    FROM person
    ORDER BY person_id DESC
    LIMIT 1;
    """, nativeQuery = true)
    Idperson traerPersona();



    @Query(value = """
    SELECT * FROM users
    WHERE user_name = :username
      AND password = :password
    LIMIT 1
    """, nativeQuery = true)
requestRegisterUser login(@Param("username") String username, @Param("password") String password);

}
