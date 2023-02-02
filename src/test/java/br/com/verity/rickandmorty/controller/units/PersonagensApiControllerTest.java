package br.com.verity.rickandmorty.controller.units;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.verity.rickandmorty.controller.PersonagensApiController;
import br.com.verity.rickandmorty.dto.PersonagensDto;
import br.com.verity.rickandmorty.service.PersonagensServiceImpl;

@ExtendWith(MockitoExtension.class)
@DisplayName("Personagens Api Controller")
public class PersonagensApiControllerTest {

	@Mock
	Logger logger;

	@Mock
	PersonagensServiceImpl personagensServiceImpl;
	
	@InjectMocks
	PersonagensApiController personagensApiController;

	@BeforeEach
	public void setUp() {
		when(logger.isDebugEnabled()).thenReturn(true);
	}
	
	@Test
	@DisplayName("Deve retornar personagens")
	public void ct1() throws Exception {
		// CENARIO
		when(personagensServiceImpl.listarPersonagens()).thenReturn(Arrays.asList(new PersonagensDto()));
		
		// ACAO
		personagensApiController.getPersonagens();
		
		// VERIFICACAO
		verify(personagensServiceImpl).listarPersonagens();
	}
	
	@Test
	@DisplayName("Deve retornar personagem por id")
	public void ct2() throws Exception {
		// CENARIO
		when(personagensServiceImpl.buscarPersonagem("0")).thenReturn(new PersonagensDto());
		
		// ACAO
		personagensApiController.getPersonagensById("0");
		
		// VERIFICACAO
		verify(personagensServiceImpl).buscarPersonagem("0");
	}

	@Test
	@DisplayName("Deve criar personagem")
	public void ct3() throws Exception {
		// CENARIO
		PersonagensDto personagensDto = new PersonagensDto();
		
		doNothing().when(personagensServiceImpl).salvarPersonagem(personagensDto);

		// ACAO
		personagensApiController.createPersonagens(personagensDto);
		
		// VERIFICACAO
		verify(personagensServiceImpl).salvarPersonagem(personagensDto);
	}
	
	@Test
	@DisplayName("Deve alterar personagem")
	public void ct4() throws Exception {
		// CENARIO
		PersonagensDto personagensDto = new PersonagensDto();

		doNothing().when(personagensServiceImpl).alterarPersonagem("0", personagensDto);

		// ACAO
		personagensApiController.updatePersonagens("0", personagensDto);
		
		// VERIFICACAO
		verify(personagensServiceImpl).alterarPersonagem("0", personagensDto);
	}
	
	@Test
	@DisplayName("Deve deletar personagem")
	public void ct5() throws Exception {
		// CENARIO
		doNothing().when(personagensServiceImpl).removerPersonagem("0");
		
		// ACAO
		personagensApiController.deletePersonagens("0");
		
		// VERIFICACAO
		verify(personagensServiceImpl).removerPersonagem("0");
	}

}
