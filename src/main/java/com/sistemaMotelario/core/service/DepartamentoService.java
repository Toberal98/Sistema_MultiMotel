/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaMotelario.core.service;

import com.sistemaMotelario.core.entity.SmDepartamento;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface DepartamentoService {
     public abstract List<SmDepartamento> findAll();
}
