/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaMotelario.core.endpoint;

import com.sistemaMotelario.core.entity.SmDepartamento;
import com.sistemaMotelario.core.entity.SmFotos;
import com.sistemaMotelario.core.entity.SmHabitacion;
import com.sistemaMotelario.core.entity.SmMotel;
import com.sistemaMotelario.core.entity.SmMunicipio;
import com.sistemaMotelario.core.service.DepartamentoService;
import com.sistemaMotelario.core.service.MotelService;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    private MotelService motels;
        // filtramos los departamentos
    @GetMapping(value = "/departamentos", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
        List <SmDepartamento>  findAll() {
        List <SmDepartamento>  lsDepartment = deparservice.findAll();
        return lsDepartment;
    }
    
    @GetMapping(value = "/lista" , produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<SmMotel> findAllMoteles(){
    	List<SmMotel> lsMotel = motels.findAll();
    	
    	return lsMotel;
    	
    }
    
    @RequestMapping(value = "/lista/{idmunicipio}/{idcategoria}/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody 
    ResponseEntity<List<SmMotel>>  getMunicipios(@PathVariable int idmunicipio, @PathVariable int idcategoria,@PathVariable String nombre ) {
        List <SmMotel>  motelFiltrado = motels.findByMunIdandCatId(idmunicipio, idcategoria, "%"+nombre+"%");
        if(motelFiltrado == null) {
        	return new ResponseEntity<List<SmMotel>>(motelFiltrado, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<SmMotel>>(motelFiltrado, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/oneMotel/{moId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody 
    ResponseEntity<SmMotel>  getMotelesID(@PathVariable int moId ) {
    	SmMotel  mot = motels.findByMoId(moId);
        if(mot == null) {
        	return new ResponseEntity<SmMotel>(mot, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<SmMotel>(mot, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/habitacion/{moId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody 
    ResponseEntity<List<SmFotos>>  getHabitaciones(@PathVariable int moId ) {
    	List<SmFotos>  h = motels.findHabitacion(moId);
        if(h == null) {
        	return new ResponseEntity<List<SmFotos>>(h, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<SmFotos>>(h, HttpStatus.OK);
    }
    			
}
