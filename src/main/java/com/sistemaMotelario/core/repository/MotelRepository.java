package com.sistemaMotelario.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sistemaMotelario.core.entity.SmMotel;


@Repository
public interface MotelRepository  extends CrudRepository<SmMotel, Integer>{

	@Query(nativeQuery = true, value="select * from sm_motel where "
			+ "((mun_id = :municipio) || (:municipio =0)) and "
			+ "((cat_id = :categoria) || (:categoria = 0)) and "
			+ "((mo_nombre like :nombre) || (:nombre = '%null%'))")
	public abstract List<SmMotel> findByMunIdandCatId(
			@Param("municipio") int municipio,
			@Param("categoria") int categoria,
			@Param("nombre") String nombre);
}
