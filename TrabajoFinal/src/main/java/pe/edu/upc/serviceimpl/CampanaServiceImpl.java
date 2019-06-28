
package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.Campana;
import pe.edu.upc.repository.CampanaRepository;
import pe.edu.upc.service.ICampanaService;

@Service
public class CampanaServiceImpl implements ICampanaService {
	
	@Autowired
	private CampanaRepository campR;

	@Override
	@Transactional
	public Integer insertar(Campana campana) {
		int rpta = campR.buscarNombreCampana(campana.getNombreCampana());
		if (rpta== 0) {		
			campR.save(campana);

		}
		return rpta;

	}

	@Override
	@Transactional
	public void modificar(Campana campana) {
		// TODO Auto-generated method stub
		campR.save(campana);
	}

	@Override
	@Transactional
	public void eliminar(int idCampana) {
		// TODO Auto-generated method stub
		campR.deleteById(idCampana);
	}

	@Override
	@Transactional
	public Optional<Campana> listarId(int idCampana) {
		// TODO Auto-generated method stub
		return campR.findById(idCampana);
	}

	@Override
	@Transactional
	public List<Campana> listar() {
		// TODO Auto-generated method stub
		return campR.findAll(Sort.by(Sort.Direction.ASC,"nombreCampana"));
	}

	@Override
	@Transactional
	public List<Campana> buscarNombre(String nombreCampana) {
		// TODO Auto-generated method stub
		return campR.findByNombreCampana(nombreCampana);
	}

}