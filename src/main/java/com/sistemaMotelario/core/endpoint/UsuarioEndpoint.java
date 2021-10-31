package com.sistemaMotelario.core.endpoint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sistemMotelario.core.pojos.UsuarioPojo;
import com.sistemaMotelario.core.entity.SmUsuario;
import com.sistemaMotelario.core.service.UsuarioService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@SessionAttributes({"usuario"})
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:19006", methods= {RequestMethod.GET,RequestMethod.POST})

public class UsuarioEndpoint {

	public static Logger log = LoggerFactory.getLogger(motelesEndpoint.class);
	@Autowired
	private UsuarioService usrService;
	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseBody 
	public ResponseEntity login(@Validated @RequestBody SmUsuario user, Model model) {
		SmUsuario usr = usrService.login(user);
		Map<String,String>  mensaje = new HashMap(); 
		mensaje.put("mensaje", "usuario o password incorrectos");
		if(usr == null){
			 return ResponseEntity
			            .status(HttpStatus.FORBIDDEN)
			            .body(mensaje);
		}
		 return ResponseEntity
		            .status(HttpStatus.OK)                 
		            .body(usr);
	}
	
	@PostMapping(path = "/newUser", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity createUser(@RequestBody UsuarioPojo usr) {
		SmUsuario usuario = usrService.createNewUser(UsuarioPojo.toEntity(usr));
		SmUsuario us = new SmUsuario();
		Map<String,String>  mensaje = new HashMap(); 
		mensaje.put("mensaje", "El usuario ya existe");
		if(usuario == null) {
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body(mensaje);
		}
		 return ResponseEntity
		            .status(HttpStatus.CREATED)                 
		            .body(usuario);
	}
}
