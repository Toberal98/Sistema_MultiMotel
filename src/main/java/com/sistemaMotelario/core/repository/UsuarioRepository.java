package com.sistemaMotelario.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sistemaMotelario.core.entity.SmUsuario;

@Repository
public interface UsuarioRepository extends CrudRepository<SmUsuario, Integer> {

	@Query(nativeQuery = true , value= "select * from sm_usuario where usr_correo = :correo  and usr_password = :password")
	public abstract SmUsuario findByCorreoAndPass(
			@Param("correo") String correo,
			@Param("password") String Password);
//	
//	@Query(nativeQuery = true, value = "insert into sm_usuario(usr_correo, usr_password,mun_id) values (:correo, :password , :municipio)")
//	public abstract SmUsuario createUser(
//			@Param("correo") String correo, 
//			@Param("password") String password, 
//			@Param("municipio") Integer municipio);
}
