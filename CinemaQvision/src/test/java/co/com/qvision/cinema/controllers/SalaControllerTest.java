package co.com.qvision.cinema.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.qvision.controller.SalaController;
import co.com.qvision.entity.Sala;
import co.com.qvision.repository.SalaRepository;
import co.com.qvision.service.SalaService;

@RunWith(SpringRunner.class)
@WebMvcTest(SalaController.class)
class SalaControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private SalaService salaService;

	private List<Sala> salaList;

	private Sala sala1;
	private Sala sala2;
	private Sala sala3;

	SalaRepository salaRepository = Mockito.mock(SalaRepository.class);

	@BeforeEach
	public void setup() throws Exception {
		Mockito.when(salaRepository.findAll()).thenReturn(Arrays.asList(sala1 = new Sala(1, "Sala1", "Sala1", 3000, 10),
				sala2 = new Sala(2, "Sala2", "Sala2", 3000, 10), sala3 = new Sala(3, "Sala3", "Sala3", 3000, 10)

		));

		this.salaList = new ArrayList<>();

		this.salaList.add(sala1);
		this.salaList.add(sala2);
		this.salaList.add(sala3);

		salaService = new SalaService(salaRepository);
	}

	@Test
	public void testList() throws Exception {

		List<Sala> expected = salaService.listService();

		assertThat(expected == salaList);
		assertThat(expected.size()).isEqualTo(3);
		assertThat(expected.get(0).getNombre()).isEqualTo(sala1.getNombre());

		BDDMockito.given(salaService.listService()).willReturn(salaList);

		this.mvc.perform(get("http://localhost:8080/sala/lista")).andExpect(status().isOk());

	}

	@Test
	public void testDetail() throws Exception {

		Sala actual = sala1;
		System.out.println(actual.getIdSala());

		BDDMockito.given(salaService.getSala(1)).willReturn(actual);

		this.mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/sala/detail/{id}", sala1.getIdSala()))
				.andExpect(status().isOk());
	}

	@Test
	public void testDetail_return_not_found_when_salaId_is_not_exist() throws Exception {

		Sala expected = salaService.getSala(5);

		Sala actual = salaRepository.getReferenceById(5);

		BDDMockito.given(expected).willReturn(actual);

		this.mvc.perform(get("http://localhost:8080/sala/detail/", 5)).andExpect(status().isNotFound());
	}

	@Test
	public void testCreate() throws Exception {

		Sala sala = new Sala();

		sala.setNombre("Test name");
		sala.setDescripcionSala("Test Description");
		sala.setValorBoleta(1000);
		sala.setCantidadSillas(5);

		salaService.saveSala(sala);
		BDDMockito.given(sala).willReturn(sala);

		this.mvc.perform(post("http://localhost:8080/sala/create/").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(sala))).andExpect(status().isCreated());

	}

	@Test
	void testUpdate() throws Exception {

		Sala expected = sala1;

		System.out.println(expected);

		ObjectMapper mapper = new ObjectMapper();

		this.mvc.perform(put("http://localhost:8080/sala/update/").content(mapper.writeValueAsString(expected))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	/**
	 * @Test void testDelete() { fail("Not yet implemented"); }
	 **/

}
