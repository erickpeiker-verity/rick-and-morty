package br.com.verity.rickandmorty.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.verity.rickandmorty.dto.PersonagensDto;
import br.com.verity.rickandmorty.model.Personagens;

@Component
public class PersonagensMapper {

    @Autowired
    ModelMapper modelMapper;

    public PersonagensDto toDto(Personagens personagem) {
        PropertyMap<Personagens, PersonagensDto> personagemMap = new PropertyMap<Personagens,PersonagensDto>() {
            protected void configure() {
                //map().setCodigo(personagem.getId());
                map().setNome(personagem.getName());
                map().setEspecie(personagem.getSpecies());
                map().setUrl(personagem.getUrl());
            }
        };
        modelMapper.addMappings(personagemMap);
        return modelMapper.map(personagem, PersonagensDto.class);
    }

    public Personagens toModel(PersonagensDto dto) {
        PropertyMap<PersonagensDto, Personagens> personagemMap = new PropertyMap<PersonagensDto, Personagens>() {
            protected void configure() {
                map().setName(dto.getNome());
                map().setSpecies(dto.getEspecie());
            }
        };
        modelMapper.addMappings(personagemMap);

        return modelMapper.map(dto, Personagens.class);
    }
    
}
