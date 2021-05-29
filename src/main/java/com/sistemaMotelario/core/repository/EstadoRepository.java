/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaMotelario.core.repository;

import com.sistemaMotelario.core.entity.SmEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author oscar
 */
@Repository
public interface EstadoRepository extends JpaRepository<SmEstado, SmEstado>{
	public abstract SmEstado findByEstId(Integer id);
}
