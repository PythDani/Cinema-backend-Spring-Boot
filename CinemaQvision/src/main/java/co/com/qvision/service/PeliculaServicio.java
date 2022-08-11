package co.com.qvision.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.qvision.entity.Pelicula;
import co.com.qvision.repository.PeliculaRepositorio;

@Service
@Transactional
public class PeliculaServicio {

	@Autowired
	PeliculaRepositorio peliculaRepositorio;

	public List<Pelicula> list() {

		return peliculaRepositorio.findAll();

	}

	public Optional<Pelicula> getOne(long idPelicula) {

		return peliculaRepositorio.findById(idPelicula);

	}

	public Optional<Pelicula> getByNombre(String titulo) {

		return peliculaRepositorio.findByTitulo(titulo);

	}

	public void save(Pelicula pelicula) {
		peliculaRepositorio.save(pelicula);
	}

	public void delete(Long idPelicula) {
		peliculaRepositorio.deleteById(idPelicula);
	}

	public boolean existsById(Long idPelicula) {
		return peliculaRepositorio.existsById(idPelicula);
	}

	public boolean existsByTitulo(String titulo) {
		return peliculaRepositorio.existsByTitulo(titulo);
	}

}

