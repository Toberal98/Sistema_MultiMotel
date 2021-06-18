package com.sistemaMotelario.core.endpoint;

import java.util.List;

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

@RestController
@SessionAttributes({"usuario"})
@RequestMapping("/users")
public class UsuarioEndpoint {

	public static Logger log = LoggerFactory.getLogger(motelesEndpoint.class);
	@Autowired
	private UsuarioService usrService;
	
	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseBody 
	public ResponseEntity<SmUsuario> login(@Validated @RequestBody SmUsuario user, Model model) {
		SmUsuario usr = usrService.login(user);
		if(usr == null){
			return new ResponseEntity<SmUsuario>(usr, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<SmUsuario>(usr, HttpStatus.OK);
	}
	
	@PostMapping(path = "/newUser", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<SmUsuario> createUser(@RequestBody UsuarioPojo usr) {
		SmUsuario usuario = usrService.createNewUser(UsuarioPojo.toEntity(usr));
		if(usuario == null) {
			return new ResponseEntity<SmUsuario>(usuario, HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<SmUsuario>(usuario, HttpStatus.CREATED);
	}
}
