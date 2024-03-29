
package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Campana;

@Repository
public interface CampanaRepository extends JpaRepository<Campana, Integer> {
	
	@Query("from Campana camp where camp.nombreCampana like %:nombreCampana%")	
	List<Campana> findByNombreCampana(String nombreCampana);

	@Query("select count(camp.nombreCampana) from Campana camp where camp.nombreCampana =:nombreCampana")
	public int buscarNombreCampana(@Param("nombreCampana")String nombreCampana);


}
