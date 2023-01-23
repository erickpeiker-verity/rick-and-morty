package br.com.verity.rickandmorty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import br.com.verity.rickandmorty.api.PersonagensApi;
import br.com.verity.rickandmorty.dto.PersonagensDto;
import br.com.verity.rickandmorty.service.PersonagensServiceImpl;
import jakarta.validation.Valid;

@Controller
public class PersonagensApiController implements PersonagensApi {

    @Autowired
    PersonagensServiceImpl personagensServiceImpl;

    @Override
    public ResponseEntity<List<PersonagensDto>> getPersonagens() {
        return new ResponseEntity<>(personagensServiceImpl.listarPersonagens(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PersonagensDto> createPersonagens(@Valid PersonagensDto body) {
        return new ResponseEntity<>(personagensServiceImpl.salvarPersonagem(body), HttpStatus.OK);
    }
    
}
