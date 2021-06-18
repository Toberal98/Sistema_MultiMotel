package com.sistemaMotelario.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sistemaMotelario.core.entity.SmHabitacion;


@Repository
public interface HabitacionRepository extends CrudRepository<SmHabitacion, Integer>{

	@Query(nativeQuery = true, value = "select * from sm_Habitacion h inner join sm_fotos f on h.ha_id = f.ha_id"
			+ " inner join sm_estado e on e.est_id = h.es_id where h.ha_id =:habitacion")
	public abstract SmHabitacion findById(@Param("habitacion") int idHabitacion);
	
	public abstract SmHabitacion findByhaId(int haId);
	
	@Query(nativeQuery = true, value = "select * from sm_Habitacion where mo_id = :moid")
	public abstract List<SmHabitacion> findByMoId(@Param("moid") int moid);
}
