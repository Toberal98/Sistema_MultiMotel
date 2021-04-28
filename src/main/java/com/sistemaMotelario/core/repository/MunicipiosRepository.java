
package com.sistemaMotelario.core.repository;
import com.sistemaMotelario.core.entity.SmMunicipio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dell
 */
@Repository
public interface MunicipiosRepository extends JpaRepository<SmMunicipio, Integer>  {
    
    @Query(nativeQuery = true, value="select * from sm_municipio where dep_id = :idDepartamento")
    public abstract List<SmMunicipio> findByIdDepartamento(@Param("idDepartamento") Integer idDepartamento);
}
