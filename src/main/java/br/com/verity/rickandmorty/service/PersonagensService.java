package br.com.verity.rickandmorty.service;

import java.util.List;

import br.com.verity.rickandmorty.dto.PersonagensDto;

public interface PersonagensService {

    List<PersonagensDto> listarPersonagens();
    PersonagensDto salvarPersonagem(PersonagensDto personagensDto);
    PersonagensDto buscarPersonagem(String personagensId);
    void alterarPersonagem(String personagensId, PersonagensDto personagemDto);
    void removerPersonagem(String personagensId);
    
}
