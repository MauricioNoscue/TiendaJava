package com.senna.HelloWorld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DTO.requestDTO;
import DTO.responseDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/*
 * para indicar que esta clase es un controller
 * se utiliza anotación Bean RestController
 * 
 */


 @RestController 

 /*
  * se configura el mapping del controller, para organizar las peticiones 
  */
  
  @RequestMapping("api/v1/home")
public class homeController {
 /*
  * GET: consultar informacion
    POST: Crear un registro
    PUT: Actualizar un registro
    PATCH: Actualización parcial
    DELETE: Eliminar un registro 
  */

  @GetMapping("/saludo1")
  public String Saludo1() {
      return "hello world tarar";
  }

  @GetMapping("/saludo2/{name}")
  public String Saludo2(@PathVariable String name) {
      return "Hello " + name;
  }

  @GetMapping("/saludo3")
  public ResponseEntity<Object> Saludo2(@RequestBody requestDTO request) {
      responseDTO response = new responseDTO(
        "hola " +request.getFirsTname()+ " " + request.getLastName()+ " su correo es : "+request.getEmail()
      );
      return new ResponseEntity<>(response,HttpStatus.OK);
  }

  
}
