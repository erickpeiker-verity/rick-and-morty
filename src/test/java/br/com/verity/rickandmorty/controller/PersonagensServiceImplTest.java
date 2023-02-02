package br.com.verity.rickandmorty.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	@DisplayName("Deve listar personagens")
	public void ct1() {
		// cenario
		List<Personagens> personagens = new ArrayList<>();
		personagens.add(new Personagens());

		when(personagensRepository.findAll()).thenReturn(personagens);
		
		// acao
		personagensServiceImpl.listarPersonagens();

		// verificacao
		verify(personagensRepository).findAll();
	}
	
	@Test
	@DisplayName("Deve salvar personagem")
	public void ct2() {
		// cenario
		Personagens personagem = new Personagens();
		PersonagensDto personagensDto = new PersonagensDto();

		when(personagensRepository.save(any(Personagens.class))).thenReturn(personagem);

		// acao
		personagensServiceImpl.salvarPersonagem(personagensDto);
		
		// verificacao
		verify(personagensRepository).save(any(Personagens.class));
	}
	
	@Test
	@DisplayName("Deve buscar personagem")
	public void ct3() {
		// cenario
		Optional<Personagens> personagem = Optional.empty();

		when(personagensRepository.findById(1L)).thenReturn(personagem);
		
		// acao
		personagensServiceImpl.buscarPersonagem("1");

		// verificacao
		verify(personagensRepository).findById(1L);
	}
	
	@Test
	@DisplayName("Deve remover personagem")
	public void ct4() {
		// cenario
		doNothing().when(personagensRepository).deleteById(1L);
		
		// acao
		personagensServiceImpl.removerPersonagem("1");
		
		// verificacao
		verify(personagensRepository).deleteById(1L);
	}
	
	@Test
	@DisplayName("Deve alterar personagem")
	public void ct5() {
		// cenario
		Personagens personagem = new Personagens();
		
		when(personagensRepository.save(any(Personagens.class))).thenReturn(personagem);

		// acao
		personagensServiceImpl.alterarPersonagem("1", new PersonagensDto());
		
		// verificacao
		verify(personagensRepository).save(any(Personagens.class));
	}
	
}
