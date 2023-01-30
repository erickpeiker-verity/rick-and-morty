package br.com.verity.rickandmorty.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.verity.rickandmorty.converter.PersonagensConverter;
import br.com.verity.rickandmorty.dto.PersonagensDto;
import br.com.verity.rickandmorty.mapper.PersonagensMapper;
import br.com.verity.rickandmorty.model.Personagens;
import br.com.verity.rickandmorty.repository.PersonagensRepository;
import jakarta.validation.Valid;

@Service
public class PersonagensServiceImpl implements PersonagensService {

    @Autowired
    PersonagensRepository personagensRepository;

    @Autowired
    PersonagensMapper personagensMapper;

    @Override
    public List<PersonagensDto> listarPersonagens() {
        List<Personagens> personagens = personagensRepository.findAll();
        return listPersonagensToDto(personagens);
    }

    @Override
    public void salvarPersonagem(PersonagensDto personagemDto) {
        Personagens personagem = personagensMapper.modelMapperPersonagens().map(personagemDto, Personagens.class);
        personagensRepository.save(personagem);
    }

    @Override
    public PersonagensDto buscarPersonagem(String personagensId) {
        Personagens personagem = 
            personagensRepository
                .findById(PersonagensConverter.stringToLong(personagensId))
                .orElse(new Personagens());
        return personagensMapper.modelMapperPersonagens().map(personagem, PersonagensDto.class);
    }

    @Override
    public void removerPersonagem(String personagensId) {
        personagensRepository.deleteById(PersonagensConverter.stringToLong(personagensId));
    }
    
    @Override
    public void alterarPersonagem(String personagensId, @Valid PersonagensDto personagemDto) {
        Personagens personagem = personagensMapper.modelMapperPersonagens().map(personagemDto, Personagens.class);
        personagensRepository.save(personagem);
    }
    
    private List<PersonagensDto> listPersonagensToDto(List<Personagens> personagens) {
        return personagens.stream()
            .map(entity -> personagensMapper.modelMapperPersonagens().map(entity, PersonagensDto.class))
            .collect(Collectors.toList());
    }

}
