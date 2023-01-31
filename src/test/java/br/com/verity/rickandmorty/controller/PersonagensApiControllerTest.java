package br.com.verity.rickandmorty.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import br.com.verity.rickandmorty.service.PersonagensServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PersonagensApiController.class)
public class PersonagensApiControllerTest {

	@MockBean
	PersonagensServiceImpl personagensServiceImpl;
	
	@Autowired
    MockMvc mockMvc;

	@Test
	public void deveRetornarPersonagens() throws Exception {
		mockMvc
		.perform(get("/v1/personagens").accept(MediaType.APPLICATION_JSON))
		.andDo(print())
        .andExpect(status().isOk());
	}
	
}
