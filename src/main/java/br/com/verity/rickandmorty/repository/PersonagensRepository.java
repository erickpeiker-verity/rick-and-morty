package br.com.verity.rickandmorty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.verity.rickandmorty.model.Personagens;

public interface PersonagensRepository extends JpaRepository<Personagens, Long> {}