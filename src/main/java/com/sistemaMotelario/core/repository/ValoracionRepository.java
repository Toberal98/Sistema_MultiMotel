package com.sistemaMotelario.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistemaMotelario.core.entity.SmValoracion;

@Repository
public interface ValoracionRepository extends CrudRepository<SmValoracion, Integer>{
	
	public abstract List<SmValoracion> findAll();
}
