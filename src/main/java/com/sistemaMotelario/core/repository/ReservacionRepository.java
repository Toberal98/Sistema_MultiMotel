package com.sistemaMotelario.core.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sistemaMotelario.core.entity.SmReservacion;


@Repository
public interface ReservacionRepository extends CrudRepository<SmReservacion, Integer>{

	public abstract List<SmReservacion> findAll();
	
	@Query(nativeQuery = true, value="select r.* from sm_reservacion r inner join sm_usuario  us on r.usr_id = us.usr_id where r.usr_id = :idUsuario order by r.res_id desc")
	public abstract List<SmReservacion> findByIdUsuario(@Param("idUsuario") int idUsuario);
}
