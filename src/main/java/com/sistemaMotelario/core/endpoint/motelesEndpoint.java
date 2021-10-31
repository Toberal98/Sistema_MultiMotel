/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaMotelario.core.endpoint;

import com.sistemMotelario.core.pojos.ReservacionPojo;
import com.sistemaMotelario.core.entity.SmDepartamento;
import com.sistemaMotelario.core.entity.SmFotos;
import com.sistemaMotelario.core.entity.SmHabitacion;
import com.sistemaMotelario.core.entity.SmMotel;
import com.sistemaMotelario.core.entity.SmMunicipio;
import com.sistemaMotelario.core.entity.SmReservacion;
import com.sistemaMotelario.core.entity.SmUsuario;
import com.sistemaMotelario.core.service.DepartamentoService;
import com.sistemaMotelario.core.service.MotelService;
import com.sistemaMotelario.core.service.ReservacionService;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/moteles")
@CrossOrigin(origins = "http://localhost:19006", methods= {RequestMethod.GET,RequestMethod.POST})

public class motelesEndpoint {
        
     public static Logger log = LoggerFactory.getLogger(motelesEndpoint.class);
    @Autowired
    private DepartamentoService deparservice;
    @Autowired
    private MotelService motels;
    @Autowired
    private ReservacionService rs;
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
    
    @GetMapping(value = "/lista/{idmunicipio}/{idcategoria}/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody 
    ResponseEntity<List<SmMotel>>  getMunicipios(@PathVariable int idmunicipio, @PathVariable int idcategoria,@PathVariable String nombre ) {
        List <SmMotel>  motelFiltrado = motels.findByMunIdandCatId(idmunicipio, idcategoria, "%"+nombre+"%");
        if(motelFiltrado == null) {
        	return new ResponseEntity<List<SmMotel>>(motelFiltrado, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<SmMotel>>(motelFiltrado, HttpStatus.OK);
    }
    
    @GetMapping(value = "/oneMotel/{moId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody 
    ResponseEntity<SmMotel>  getMotelesID(@PathVariable int moId ) {
    	SmMotel  mot = motels.findByMoId(moId);
        if(mot == null) {
        	return new ResponseEntity<SmMotel>(mot, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<SmMotel>(mot, HttpStatus.OK);
    }
    
    @GetMapping(value = "/habitacion/{moId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody 
    ResponseEntity<List<SmHabitacion>>  getHabitaciones(@PathVariable int moId ) {
    	List<SmHabitacion>  h = motels.findHabitacion(moId);
        if(h == null) {
        	return new ResponseEntity<List<SmHabitacion>>(h, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<SmHabitacion>>(h, HttpStatus.OK);
    }
    
    @GetMapping(value = "/habitacionIndividual/{idHabitacion}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody 
    ResponseEntity<SmHabitacion>  getHabitacionIndividual(@PathVariable int idHabitacion ) {
    	SmHabitacion h = motels.findById(idHabitacion);
        if(h == null) {
        	return new ResponseEntity<SmHabitacion>(h, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<SmHabitacion>(h, HttpStatus.OK);
    }
    
    @GetMapping(value = "/reservaciones", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody 
    ResponseEntity<List<SmReservacion>>  getReservaciones() {
    	List<SmReservacion> listado = rs.findAll();
        if(listado == null) {
        	return new ResponseEntity<List<SmReservacion>>(listado, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<SmReservacion>>(listado, HttpStatus.OK);
    }
    
    @GetMapping(value = "/reservaciones/{idUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody 
    ResponseEntity<List<SmReservacion>>  getReservacionesbyidusuario(@PathVariable int idUsuario ) {
    	List<SmReservacion> listadoByusu = rs.findReservation(idUsuario);
        if(listadoByusu == null) {
        	return new ResponseEntity<List<SmReservacion>>(listadoByusu, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<SmReservacion>>(listadoByusu, HttpStatus.OK);
    }
    
    @PostMapping(path = "/reservar", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity  createReservacion(@RequestBody ReservacionPojo smres) {
    	
		return rs.reservacion(ReservacionPojo.toEntity(smres));
	}
    			
}
