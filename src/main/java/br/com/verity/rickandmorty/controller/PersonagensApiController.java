package br.com.verity.rickandmorty.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.verity.rickandmorty.api.PersonagensApi;
import br.com.verity.rickandmorty.dto.PersonagensDto;
import br.com.verity.rickandmorty.service.PersonagensServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1")
public class PersonagensApiController implements PersonagensApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PersonagensApiController.class);

    @Autowired
    PersonagensServiceImpl personagensServiceImpl;

    @Override
    public ResponseEntity<List<PersonagensDto>> getPersonagens() {
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("Listar personagens");
        }
        return new ResponseEntity<>(personagensServiceImpl.listarPersonagens(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PersonagensDto> getPersonagensById(String personagensId) {
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("Buscar personagem de código {}", personagensId);
        }
        return new ResponseEntity<>(personagensServiceImpl.buscarPersonagem(personagensId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PersonagensDto> createPersonagens(@Valid PersonagensDto body) {
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("Salvar personagem - {}", body);
        }
        return new ResponseEntity<>(personagensServiceImpl.salvarPersonagem(body), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updatePersonagens(String personagensId, @Valid PersonagensDto body) {
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("Atualizar personagem - {}", personagensId);
        }
        personagensServiceImpl.alterarPersonagem(personagensId, body);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deletePersonagens(String personagensId) {
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("Remover personagem - {}", personagensId);
        }
        personagensServiceImpl.removerPersonagem(personagensId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
