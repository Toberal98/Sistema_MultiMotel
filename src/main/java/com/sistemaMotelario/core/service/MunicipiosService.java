package com.sistemaMotelario.core.service;

import com.sistemaMotelario.core.entity.SmMunicipio;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Douglas Menjivar
 */
public interface MunicipiosService {
    public abstract List<SmMunicipio> findByIdDepartamento(Integer idDepartamento);
}
