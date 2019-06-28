package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.Boleta;
import pe.edu.upc.repository.BoletaRepository;
import pe.edu.upc.service.IBoletaService;

@Service
public class BoletaServiceImpl implements IBoletaService{

	
	@Autowired
	private BoletaRepository boletaRepository;

	@Transactional	
	@Override
	public Boleta insertar(Boleta boleta) {
		// TODO Auto-generated method stub
		return boletaRepository.save(boleta);
	}

	@Transactional
	@Override
	public List<Boleta> listar() {
		// TODO Auto-generated method stub
		return boletaRepository.findAll();
	}
	
	
}
