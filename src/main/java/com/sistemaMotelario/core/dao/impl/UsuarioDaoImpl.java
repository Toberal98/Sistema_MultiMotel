package com.sistemaMotelario.core.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sistemaMotelario.core.dao.UsuarioDao;
import com.sistemaMotelario.core.entity.SmUsuario;
import com.sistemaMotelario.core.repository.UsuarioRepository;

@Component
public class UsuarioDaoImpl implements UsuarioDao{

	 public static Logger log = LoggerFactory.getLogger(MunicipioDaoImpl.class);
	 @Autowired
	 private UsuarioRepository user;
	@Override
	public SmUsuario login(SmUsuario Usuario) {
		 try {
            log.info("Buscando un registro de usuario en la base de datos por nombre de usuario: " + Usuario.getUsrCorreo());
            SmUsuario usuario = user.findByCorreoAndPass(Usuario.getUsrCorreo(), Usuario.getUsrPassword());
            if (usuario == null) {
                log.warn("no se encontro ningun registro");
                return null;
            }
				return usuario;
			} catch (Exception e) {
				e.printStackTrace();
				log.error("posible causa: " + e.getCause());
				return null;
			}
		
	}
	@Override
	public SmUsuario createUser(SmUsuario Usuario) {
		try {
			
	            log.info("Creando el usuario con correo : " + Usuario.getUsrCorreo());
	            SmUsuario usuarioV = user.findByCorreoAndPass(Usuario.getUsrCorreo(), Usuario.getUsrPassword());
	            if(usuarioV == null ) {
	            	SmUsuario usuario = user.save(Usuario);
	            	if (usuario == null) {
		                log.warn("no se ha podido crear intentalo de nuevo");
		                return null;
	            		}
	            	return usuario;
	            }else {
	            	return null;
	            }
	            
			} catch (Exception e) {
			e.printStackTrace();
			log.error("posible causa: " + e.getCause());
			return null;
		}
				
	}

}
