package br.com.verity.rickandmorty.service;

import java.util.List;

import br.com.verity.rickandmorty.dto.PersonagensDto;

public interface PersonagensService {

    PersonagensDto salvarPersonagem(PersonagensDto personagensDto);
    List<PersonagensDto> listarPersonagens();
    
}
