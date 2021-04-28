package com.sistemaMotelario.core.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaMotelario.core.dao.UsuarioDao;
import com.sistemaMotelario.core.dao.impl.MunicipioDaoImpl;
import com.sistemaMotelario.core.entity.SmUsuario;
import com.sistemaMotelario.core.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	 public static Logger log = LoggerFactory.getLogger(MunicipioDaoImpl.class);
	 @Autowired
	 private UsuarioDao usu;
	@Override
	public SmUsuario login(SmUsuario Usuario) {
		
		try {
			log.info("Extrayendo Usuario desde la base de datos");
			SmUsuario usr = usu.login(Usuario);
			if (usr == null) {
                log.warn("usuario no fue encontrado");
                return null;
        }
        return usr;
		} catch (Exception e) {
			 e.printStackTrace();
             log.error(", posible causa: " + e.getCause());
             return null;
		}
	}

}
