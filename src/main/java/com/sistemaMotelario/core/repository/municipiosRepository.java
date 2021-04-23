
package com.sistemaMotelario.core.repository;
import com.sistemaMotelario.core.entity.SmMunicipio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Dell
 */
public interface municipiosRepository extends JpaRepository<SmMunicipio, Integer>  {
    
}
