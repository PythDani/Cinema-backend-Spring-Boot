package co.com.qvision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.qvision.entity.Sala;
import co.com.qvision.repository.SalaRepository;

@Service
public class SalaService {

	@Autowired
	private SalaRepository salaRepository;

	public SalaService(SalaRepository salaRepository) {
		super();
		this.salaRepository = salaRepository;
	}

	public List<Sala> listService() {

		return salaRepository.findAll();

	}

	public Sala getSala(int idSala) {

		return salaRepository.findByIdSala(idSala);

	}

	public void saveSala(Sala sala) {

		salaRepository.save(sala);

	}

	public void delete(int idSala) {

		salaRepository.deleteById(idSala);

	}

	public boolean existsById(int idSala) {
		return salaRepository.existsById(idSala);
	}

	public boolean existsByNombre(String nombre) {
		return salaRepository.existsByNombre(nombre);
	}

}
