package br.com.verity.rickandmorty;

import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.modelmapper.spring.SpringIntegration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RickandmortyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RickandmortyApplication.class, args);
	}

}
