/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaMotelario.core.endpoint;

import com.sistemaMotelario.core.entity.SmDepartamento;
import com.sistemaMotelario.core.entity.SmMunicipio;
import com.sistemaMotelario.core.service.DepartamentoService;
import com.sistemaMotelario.core.service.MunicipiosService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Dell
 */
@RestController
@SessionAttributes({"usuario"})
@RequestMapping("/municipios")
@CrossOrigin(origins = "http://localhost:19006", methods= {RequestMethod.GET,RequestMethod.POST})

public class MunicipioEndpoint {
     public static Logger log = LoggerFactory.getLogger(motelesEndpoint.class);
    @Autowired
    private MunicipiosService munservice;
    
    @RequestMapping(value = "/lista/{idDepartamento}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody 
        List <SmMunicipio>  getMunicipios(@PathVariable Integer idDepartamento) {
        List <SmMunicipio>  lsMunicipios = munservice.findByIdDepartamento(idDepartamento);
        return lsMunicipios;
    }
    
}
