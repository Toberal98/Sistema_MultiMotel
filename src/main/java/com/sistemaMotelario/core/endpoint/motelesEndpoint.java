/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaMotelario.core.endpoint;

import com.sistemaMotelario.core.entity.SmDepartamento;
import com.sistemaMotelario.core.service.DepartamentoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Dell
 */
@RestController
@SessionAttributes({"usuario"})
@RequestMapping("/moteles")
public class motelesEndpoint {
        
      public static Logger log = LoggerFactory.getLogger(motelesEndpoint.class);
    @Autowired
    private DepartamentoService deparservice;
        // filtramos los departamentos
    @GetMapping(value = "/departamentos", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
        List <SmDepartamento>  findAll() {
        List <SmDepartamento>  lsDepartment = deparservice.findAll();
        return lsDepartment;
    }
        
    @GetMapping("/")
     public String home(){
         return "Hello World!";
     }
    
}
