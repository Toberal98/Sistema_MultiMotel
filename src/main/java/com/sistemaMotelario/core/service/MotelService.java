package com.sistemaMotelario.core.service;

import java.util.List;

import com.sistemaMotelario.core.entity.SmHabitacion;
import com.sistemaMotelario.core.entity.SmMotel;

public interface MotelService {
	public abstract List<SmMotel> findAll();
	public abstract List<SmMotel> findByMunIdandCatId(int idmunicipio, int idcategoria, String nombre);
	public abstract SmMotel findByMoId(int moId);
	public abstract List<SmHabitacion> findHabitacion(int moId);
	public abstract SmHabitacion findById(int idHabitacion);
}
