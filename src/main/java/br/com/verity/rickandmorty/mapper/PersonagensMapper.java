package br.com.verity.rickandmorty.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.verity.rickandmorty.converter.PersonagensConverter;
import br.com.verity.rickandmorty.dto.PersonagensDto;
import br.com.verity.rickandmorty.model.Personagens;

@Configuration
public class PersonagensMapper {

    @Bean
    public ModelMapper modelMapperPersonagens() {
        final ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        final PropertyMap<Personagens, PersonagensDto> personagemToDtoMap = new PropertyMap<Personagens,PersonagensDto>() {
            protected void configure() {
                map().setStatus(source.getStatus());
                map().setUrl(source.getUrl());
                using(PersonagensConverter.longToInteger())
                    .map(source.getId(), destination.getCodigo());
                map().setGenero(source.getGender());
                map().setNome(source.getName());
                map().setEspecie(source.getSpecies());
                map().setTipo(source.getType());
                map().setEpisodios(source.getEpisode());
            }
        };

        final PropertyMap<PersonagensDto, Personagens> dtoToPersonagemMap = new PropertyMap<PersonagensDto, Personagens>() {
            protected void configure() {
                using(PersonagensConverter.integerToLong())
                    .map(source.getCodigo(), destination.getId());
                map().setName(source.getNome());
                map().setStatus(source.getStatus());
                map().setSpecies(source.getEspecie());
                map().setType(source.getTipo());
                map().setGender(source.getGenero());
                using(PersonagensConverter.listToArrayList())
                    .map(source.getEpisodios(), destination.getEpisode());
                map().setUrl(source.getUrl());
            }
        };

        modelMapper.addMappings(personagemToDtoMap);
        modelMapper.addMappings(dtoToPersonagemMap);
        return modelMapper;
    }

}
