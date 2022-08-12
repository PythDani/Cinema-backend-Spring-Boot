package co.com.qvision.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.qvision.entity.Sala;
import co.com.qvision.service.SalaService;

@RestController
@RequestMapping("/sala")
@CrossOrigin(origins = "*")
public class SalaController {

	@Autowired
	SalaService salaService;

	@GetMapping("/lista")
	public ResponseEntity<?> list() {

		try {

			List<Sala> list = salaService.listService();
			return new ResponseEntity<List<Sala>>(list, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Hubo un error al ejecutar", HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@GetMapping("/detail/{idSala}")
	public ResponseEntity<?> detail(@PathVariable("idSala") int idSala) {

		try {

			if (!salaService.existsById(idSala)) {

				return new ResponseEntity<String>("No existe la sala " + idSala, HttpStatus.NOT_FOUND);

			} else {

				Sala sala = salaService.getSala(idSala);

				return new ResponseEntity<Sala>(sala, HttpStatus.OK);

			}

		} catch (Exception e) {
			return new ResponseEntity<String>("Hubo un error al ejecutar", HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Sala sala) {

		if (salaService.existsByNombre(sala.getNombre())) {

			return new ResponseEntity<String>("La Sala " + sala.getNombre() + " ya existe", HttpStatus.NOT_ACCEPTABLE);

		}

		Sala salaNew = new Sala(sala.getNombre(),
								sala.getDescripcionSala(),
								sala.getValorBoleta(),
								sala.getCantidadSillas());

		salaService.saveSala(salaNew);
		return new ResponseEntity<String>("Sala creada con éxito", HttpStatus.CREATED);

	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Sala sala) {

		if (!salaService.existsById(sala.getIdSala()))
			return new ResponseEntity<String>("La Sala que deseas actualizar, no existe", HttpStatus.NOT_FOUND);

		try {

			Sala salaUp = salaService.getSala(sala.getIdSala());
			salaUp.setNombre(sala.getNombre());
			salaUp.setDescripcionSala(sala.getDescripcionSala());
			salaUp.setValorBoleta(sala.getValorBoleta());
			salaUp.setCantidadSillas(sala.getCantidadSillas());

			salaService.saveSala(salaUp);

			return new ResponseEntity<String>("Sala actualizada exitosamente", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Hubo un error al ejecutar", HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@DeleteMapping("/delete/{idSala}")
	public ResponseEntity<?> delete(@PathVariable("idSala") int idSala) {

		if (!salaService.existsById(idSala))
			return new ResponseEntity<String>("La Sala que deseas borrar, no existe", HttpStatus.NOT_FOUND);

		try {

			salaService.delete(idSala);
			return new ResponseEntity<String>("Sala borrada con éxito", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Hubo un error al ejecutar", HttpStatus.NOT_ACCEPTABLE);
		}

	}

}
