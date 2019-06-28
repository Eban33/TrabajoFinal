package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Comentario;

public interface IComentarioService {

	
	public Comentario insertar(Comentario comentario);
	
	List<Comentario> listar();
}
