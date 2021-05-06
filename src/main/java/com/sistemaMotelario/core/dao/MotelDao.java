package com.sistemaMotelario.core.dao;

import java.util.List;

import com.sistemaMotelario.core.entity.SmFotos;
import com.sistemaMotelario.core.entity.SmHabitacion;
import com.sistemaMotelario.core.entity.SmMotel;

public interface MotelDao {
	
	public abstract List<SmMotel> findAll();
	public abstract List<SmMotel> findByMunIdandCatId(int idmunicipio, int idcategoria, String nombre);
	public abstract SmMotel findByMoId(int moId);
	public abstract List<SmFotos> findHabitacion(int moId);

}
