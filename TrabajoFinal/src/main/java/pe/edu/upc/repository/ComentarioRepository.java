package pe.edu.upc.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



import pe.edu.upc.entity.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {




	
}
