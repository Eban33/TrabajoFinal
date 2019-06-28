package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Boleta;


public interface IBoletaService {
	public Boleta insertar(Boleta boleta);
	
	List<Boleta> listar();
}
