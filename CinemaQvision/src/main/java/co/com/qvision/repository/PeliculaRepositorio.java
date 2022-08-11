<<<<<<< HEAD
package co.com.qvision.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.qvision.entity.Pelicula;


@Repository
public interface PeliculaRepositorio extends JpaRepository<Pelicula, Long>{
	
	Optional <Pelicula> findByTitulo(String titulo);

	List<Pelicula> findAll();
	
	boolean existsByTitulo(String titulo);
	
	

}
=======
package co.com.qvision.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.qvision.entity.Pelicula;


@Repository
public interface PeliculaRepositorio extends JpaRepository<Pelicula, Long>{
	
	Optional <Pelicula> findByTitulo(String titulo);

	List<Pelicula> findAll();
	
	boolean existsByTitulo(String titulo);
	
	

}
>>>>>>> c279d74573521fb1c19c0445369c524062666945
