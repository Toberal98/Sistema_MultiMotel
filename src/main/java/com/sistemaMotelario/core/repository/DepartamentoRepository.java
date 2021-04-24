/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaMotelario.core.repository;


import com.sistemaMotelario.core.entity.SmDepartamento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dell
 */
@Repository
public interface DepartamentoRepository  extends JpaRepository<SmDepartamento, Integer>{
    
    public abstract List<SmDepartamento> findAll();
}
