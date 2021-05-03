package com.sistemaMotelario.core.dao;

import java.util.List;

import com.sistemaMotelario.core.entity.SmMotel;

public interface MotelDao {
	
	public abstract List<SmMotel> findAll();
	public abstract List<SmMotel> findByMunIdandCatId(int idmunicipio, int idcategoria, String nombre);

}
