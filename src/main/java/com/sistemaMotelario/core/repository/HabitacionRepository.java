package com.sistemaMotelario.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sistemaMotelario.core.entity.SmHabitacion;


@Repository
public interface HabitacionRepository extends CrudRepository<SmHabitacion, Integer>{

	@Query(nativeQuery = true, value= "select * from sm_Habitacion h inner join sm_fotos f on h.ha_id = f.ha_id"
			+ " where h.mo_id = :motel and f.fh_descripcion LIKE '%Portada%'")
	public abstract List<SmHabitacion> findHabitaciones(@Param("motel") int moId);
}
