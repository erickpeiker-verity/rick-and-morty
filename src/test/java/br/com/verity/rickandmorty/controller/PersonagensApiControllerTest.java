package br.com.verity.rickandmorty.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.verity.rickandmorty.dto.PersonagensDto;
import br.com.verity.rickandmorty.service.PersonagensServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PersonagensApiController.class)
@DisplayName("Personagens Api Controller")
public class PersonagensApiControllerTest {

	@MockBean
	PersonagensServiceImpl personagensServiceImpl;
	
	@Autowired
    MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	PersonagensDto personagensDto;
	List<PersonagensDto> listPersonagensDto;
	List<String> episodios;

	@BeforeEach
	public void setUp() {
		episodios = new ArrayList<>();
		episodios.add("https://rickandmortyapi.com/api/episode/1");
		episodios.add("https://rickandmortyapi.com/api/episode/2");
		
		personagensDto = new PersonagensDto();
		personagensDto.setCodigo(2);
		personagensDto.setNome("Morty Smith");
		personagensDto.setStatus("Alive");
		personagensDto.setEspecie("Human");
		personagensDto.setTipo("");
		personagensDto.setUrl("https://rickandmortyapi.com/api/character/2");
		personagensDto.setGenero("Male");
		personagensDto.setEpisodios(episodios);
		
		listPersonagensDto = new ArrayList<>();
		listPersonagensDto.add(personagensDto);
	}
	
	@Test
	@DisplayName("Deve retornar personagens")
	public void ct1() throws Exception {
		when(personagensServiceImpl.listarPersonagens()).thenReturn(listPersonagensDto);
		
		mockMvc.perform(get("/v1/personagens"))
		.andDo(print())
        .andExpect(status().isOk());
	}

	@Test
	@DisplayName("Deve retornar personagem por id")
	public void ct2() throws Exception {
		when(personagensServiceImpl.buscarPersonagem("2")).thenReturn(personagensDto);
		
		mockMvc.perform(
				get("/v1/personagens/2")
				.content(objectMapper.writeValueAsString(personagensDto)))
		.andDo(print())
        .andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("Nao deve retornar personagem sem id")
	public void ct3() throws Exception {
		mockMvc.perform(get("/v1/personagens/"))
		.andDo(print())
        .andExpect(status().isNotFound());
	}
	
	@Test
	@DisplayName("Deve criar personagem")
	public void ct4() throws Exception {
		mockMvc.perform(post("/v1/personagens")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(personagensDto)))
		.andDo(print())
        .andExpect(status().isOk());
	}

	@Test
	@DisplayName("Nao deve criar personagem sem media type")
	public void ct5() throws Exception {
		mockMvc.perform(post("/v1/personagens")
			.content(objectMapper.writeValueAsString(personagensDto)))
		.andDo(print())
        .andExpect(status().isUnsupportedMediaType());
	}
	
	@Test
	@DisplayName("Nao deve criar personagem sem media body")
	public void ct6() throws Exception {
		mockMvc.perform(post("/v1/personagens")
			.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
        .andExpect(status().isBadRequest());
	}
	
	@Test
	@DisplayName("Deve alterar personagem")
	public void ct7() throws Exception {
		mockMvc.perform(put("/v1/personagens/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(personagensDto)))
		.andDo(print())
        .andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("Nao deve alterar personagem sem id")
	public void ct8() throws Exception {
		mockMvc.perform(put("/v1/personagens/")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(personagensDto)))
		.andDo(print())
        .andExpect(status().isNotFound());
	}
	
	@Test
	@DisplayName("Nao deve alterar personagem sem media type")
	public void ct9() throws Exception {
		mockMvc.perform(put("/v1/personagens/1")
			.content(objectMapper.writeValueAsString(personagensDto)))
		.andDo(print())
        .andExpect(status().isUnsupportedMediaType());
	}
	
	@Test
	@DisplayName("Nao deve alterar personagem sem body")
	public void ct10() throws Exception {
		mockMvc.perform(put("/v1/personagens/1")
			.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
        .andExpect(status().isBadRequest());
	}

	@Test
	@DisplayName("Deve deletar personagem")
	public void ct11() throws Exception {
		mockMvc.perform(delete("/v1/personagens/1"))
		.andDo(print())
        .andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("Nao deve deletar personagem sem id")
	public void ct12() throws Exception {
		mockMvc.perform(delete("/v1/personagens/"))
		.andDo(print())
        .andExpect(status().isNotFound());
	}
	
	@Test
	@DisplayName("Nao deve encontrar endpoint de personagens com path errado")
	public void ct13() throws Exception {
		mockMvc.perform(delete("/v1/personagens"))
		.andDo(print())
        .andExpect(status().isMethodNotAllowed());
	}

}
