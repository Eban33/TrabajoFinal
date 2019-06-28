
package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Campana;

public interface ICampanaService {
	
	public Integer insertar (Campana campana);
	
	public void modificar(Campana campana);
	
	public void eliminar(int idCampana);
	
	Optional<Campana> listarId(int idCampana);
	
	List<Campana> listar();
	
	List<Campana> buscarNombre(String nombreCampana);

}
