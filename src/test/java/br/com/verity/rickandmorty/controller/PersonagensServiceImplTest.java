package br.com.verity.rickandmorty.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.verity.rickandmorty.dto.PersonagensDto;
import br.com.verity.rickandmorty.mapper.PersonagensMapper;
import br.com.verity.rickandmorty.model.Personagens;
import br.com.verity.rickandmorty.repository.PersonagensRepository;
import br.com.verity.rickandmorty.service.PersonagensServiceImpl;

@ExtendWith(MockitoExtension.class)
@DisplayName("Personagens Service Implementacao")
public class PersonagensServiceImplTest {
	
	@Mock
	PersonagensRepository personagensRepository;
	
	@Spy
	PersonagensMapper personagensMapper;
	
	@InjectMocks
	PersonagensServiceImpl personagensServiceImpl;
	
	@Test
	@DisplayName("Deve listar personagens")
	public void ct1() {
		// CENARIO
		List<Personagens> personagens = new ArrayList<>();
		personagens.add(new Personagens());

		when(personagensRepository.findAll()).thenReturn(personagens);
		
		// ACAO
		List<PersonagensDto> response = personagensServiceImpl.listarPersonagens();

		// VERIFICACAO
		verify(personagensRepository).findAll();
		assertTrue(response.get(0) instanceof PersonagensDto);
	}
	
	@Test
	@DisplayName("Deve salvar personagem")
	public void ct2() {
		// CENARIO
		Personagens personagem = new Personagens();
		PersonagensDto personagensDto = new PersonagensDto();

		when(personagensRepository.save(any(Personagens.class))).thenReturn(personagem);

		// ACAO
		personagensServiceImpl.salvarPersonagem(personagensDto);
		
		// VERIFICACAO
		verify(personagensRepository).save(any(Personagens.class));
	}
	
	@Test
	@DisplayName("Deve buscar personagem")
	public void ct3() {
		// CENARIO
		Optional<Personagens> personagem = Optional.empty();

		when(personagensRepository.findById(1L)).thenReturn(personagem);
		
		// ACAO
		PersonagensDto response = personagensServiceImpl.buscarPersonagem("1");

		// VERIFICACAO
		verify(personagensRepository).findById(1L);
		assertTrue(response instanceof PersonagensDto);
	}
	
	@Test
	@DisplayName("Deve remover personagem")
	public void ct4() {
		// CENARIO
		doNothing().when(personagensRepository).deleteById(1L);
		
		// ACAO
		personagensServiceImpl.removerPersonagem("1");
		
		// VERIFICACAO
		verify(personagensRepository).deleteById(1L);
	}
	
	@Test
	@DisplayName("Deve alterar personagem")
	public void ct5() {
		// CENARIO
		Personagens personagem = new Personagens();
		
		when(personagensRepository.save(any(Personagens.class))).thenReturn(personagem);

		// ACAO
		personagensServiceImpl.alterarPersonagem("1", new PersonagensDto());
		
		// VERIFICACAO
		verify(personagensRepository).save(any(Personagens.class));
	}
	
}
