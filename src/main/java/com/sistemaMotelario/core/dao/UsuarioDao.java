package com.sistemaMotelario.core.dao;

import java.util.List;

import com.sistemaMotelario.core.entity.SmUsuario;

public interface UsuarioDao {
	
	public abstract SmUsuario login(SmUsuario Usuario);
	public abstract SmUsuario createUser(SmUsuario Usuario);

}
