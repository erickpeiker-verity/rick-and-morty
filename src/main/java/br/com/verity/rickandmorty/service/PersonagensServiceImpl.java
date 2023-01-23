package br.com.verity.rickandmorty.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.verity.rickandmorty.dto.PersonagensDto;
import br.com.verity.rickandmorty.mapper.PersonagensMapper;
import br.com.verity.rickandmorty.model.Personagens;
import br.com.verity.rickandmorty.repository.PersonagensRepository;

@Service
public class PersonagensServiceImpl implements PersonagensService {

    @Autowired
    PersonagensRepository personagensRepository;

    @Autowired
    PersonagensMapper personagensMapper;

    @Override
    public List<PersonagensDto> listarPersonagens() {
        List<Personagens> personagens = personagensRepository.findAll();
        return personagens.stream().map(personagensMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public PersonagensDto salvarPersonagem(PersonagensDto personagemDto) {
        Personagens personagem = personagensMapper.toModel(personagemDto);
        Personagens personagemSaved = personagensRepository.save(personagem);
        return personagensMapper.toDto(personagemSaved);
    }
    
}
