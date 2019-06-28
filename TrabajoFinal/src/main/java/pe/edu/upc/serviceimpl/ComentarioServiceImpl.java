package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.Comentario;
import pe.edu.upc.repository.ComentarioRepository;
import pe.edu.upc.service.IComentarioService;

@Service
public class ComentarioServiceImpl implements IComentarioService{

	
	@Autowired
	private ComentarioRepository cR;

	@Override
	@Transactional
	public Comentario insertar(Comentario comentario) {
		// TODO Auto-generated method stub
	
		
		return cR.save(comentario);
	}

	@Override
	@Transactional
	public List<Comentario> listar() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}
	
	
}
