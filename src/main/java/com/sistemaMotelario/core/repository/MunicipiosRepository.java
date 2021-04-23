
package com.sistemaMotelario.core.repository;
import com.sistemaMotelario.core.entity.SmMunicipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Douglas Menjivar
 */
@Repository
public interface MunicipiosRepository extends JpaRepository<SmMunicipio, Integer>  {
        
    
    
}
