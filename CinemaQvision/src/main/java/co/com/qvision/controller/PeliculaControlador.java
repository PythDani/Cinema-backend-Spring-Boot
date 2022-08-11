package co.com.qvision.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.qvision.dto.PeliculaDto;
import co.com.qvision.entity.Pelicula;
import co.com.qvision.service.PeliculaServicio;

@RestController
@RequestMapping("/pelicula")
@CrossOrigin(origins = "*")
public class PeliculaControlador {

	@Autowired
	PeliculaServicio peliculaServicio;
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody PeliculaDto peliculaDto) {

		if (peliculaServicio.existsByTitulo(peliculaDto.getTitulo())) {
			return new ResponseEntity<Pelicula>(HttpStatus.BAD_REQUEST);
		}

		Pelicula pelicula = new Pelicula(peliculaDto.getTitulo(), peliculaDto.getGenero(),
				peliculaDto.getImagenPromocional(), peliculaDto.getSinopsis(), peliculaDto.getDuracion(),
				peliculaDto.getFechaEstreno(), peliculaDto.getFormato(), peliculaDto.getEstadoPelicula());

		peliculaServicio.save(pelicula);
		return new ResponseEntity<Pelicula>(HttpStatus.OK);

	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{idPelicula}")
	public ResponseEntity<?> update(@PathVariable("idPelicula") long idPelicula, @RequestBody PeliculaDto peliculaDto) {
		if (!peliculaServicio.existsById(idPelicula))
			return new ResponseEntity<Pelicula>(HttpStatus.NOT_FOUND);
		

		Pelicula pelicula = peliculaServicio.getOne(idPelicula).get();
		pelicula.setTitulo(peliculaDto.getTitulo());
		pelicula.setGenero(peliculaDto.getGenero());
		pelicula.setImagenPromocional(peliculaDto.getImagenPromocional());
		pelicula.setSinopsis(peliculaDto.getSinopsis());
		pelicula.setDuracion(peliculaDto.getDuracion());
		pelicula.setFechaEstreno(pelicula.getFechaEstreno());
		pelicula.setFormato(peliculaDto.getFormato());
		pelicula.setEstadoPelicula(peliculaDto.getEstadoPelicula());

		return new ResponseEntity<Pelicula>(HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{idPelicula}")
	public ResponseEntity<?> delete(@PathVariable("idPelicula") long idPelicula) {
		if (!peliculaServicio.existsById(idPelicula))
			return new ResponseEntity<Pelicula>(HttpStatus.NOT_FOUND);
		peliculaServicio.delete(idPelicula);
		return new ResponseEntity<Pelicula>(HttpStatus.OK);
	}

	@GetMapping("/lista")
	public ResponseEntity<List<Pelicula>> list() {
		List<Pelicula> list = peliculaServicio.list();
		return new ResponseEntity<List<Pelicula>>(list, HttpStatus.OK);

	}

	@GetMapping("/detail/{idPelicula}")
	public ResponseEntity<Pelicula> getById(@PathVariable("idPelicula") long idPelicula) {

		if (!peliculaServicio.existsById(idPelicula)) {

			return new ResponseEntity<Pelicula>(HttpStatus.NOT_FOUND);

		}

		Pelicula pelicula = peliculaServicio.getOne(idPelicula).get();
		return new ResponseEntity<Pelicula>(pelicula, HttpStatus.OK);

	}

	@GetMapping("/detailtitle/{titulo}")
	public ResponseEntity<Pelicula> getByNombre(@PathVariable("titulo") String titulo) {
		if (!peliculaServicio.existsByTitulo(titulo))
			return new ResponseEntity<Pelicula>(HttpStatus.NOT_FOUND);
		Pelicula pelicula = peliculaServicio.getByNombre(titulo).get();
		return new ResponseEntity<Pelicula>(pelicula, HttpStatus.OK);
	}

}
