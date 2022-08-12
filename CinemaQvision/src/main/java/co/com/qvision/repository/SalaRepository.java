package co.com.qvision.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.qvision.entity.Sala;



public interface SalaRepository extends JpaRepository<Sala, Integer>{
	
	Sala findByIdSala(int idSala);
	
	boolean existsByNombre(String nombre);
	
	boolean existsByIdSala(long idSala);
	
}

