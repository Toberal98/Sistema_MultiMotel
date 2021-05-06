package com.sistemaMotelario.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sistemaMotelario.core.entity.SmFotos;
import com.sistemaMotelario.core.entity.SmHabitacion;


@Repository
public interface FotoRepository extends CrudRepository<SmFotos, Integer>{

	@Query(nativeQuery = true, value = "select * from sm_fotos f inner join sm_habitacion h on f.ha_id = h.ha_id "
			+ "where h.mo_id = :motel and f.fh_descripcion = 'Portada'")
	public abstract List<SmFotos> findHabitaciones(@Param("motel") int moId);
}
