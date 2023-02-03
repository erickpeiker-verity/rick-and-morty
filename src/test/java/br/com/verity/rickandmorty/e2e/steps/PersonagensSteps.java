package br.com.verity.rickandmorty.e2e.steps;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.web.server.LocalServerPort;

import br.com.verity.rickandmorty.dto.PersonagensDto;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PersonagensSteps {

	Response response;
	RequestSpecification requestSpecification;
	PersonagensDto personagensDto;
	
	@LocalServerPort
	int port;
	
	@Before
	public void setUp() {
		RestAssured.port = port;
		requestSpecification = RestAssured
		.given()
			.contentType(ContentType.JSON);
	}
	
	@Dado("parametrizar um usuario")
	public void parametrizarUmUsuario(DataTable dataTable) {
		personagensDto = new PersonagensDto();
		
		dataTable.asMaps().forEach(data -> {
			List<String> episodios = new ArrayList<>();
			episodios.add(data.get("EPISODIO"));
			
			personagensDto.setNome(data.get("NOME"));
			personagensDto.setStatus(data.get("STATUS"));
			personagensDto.setEspecie(data.get("ESPECIE"));
			personagensDto.setTipo(data.get("TIPO"));
			personagensDto.setGenero(data.get("GENERO"));
			personagensDto.setEpisodios(episodios);
			personagensDto.setUrl(data.get("URL"));			
		});
	}
	
	@Dado("retornar todos personagens")
	public void retornarTodosPersonagens() {
		response = requestSpecification
		.when()
			.basePath("/v1/personagens")
			.log()
			.all()
			.get();
	}
	
	@Dado("retornar um personagem {string}")
	public void retornarUmPersonagem(String id) {
		response = requestSpecification
		.when()
			.basePath("/v1/personagens/" + id)
			.log()
			.all()
			.get();
	}
	
	@Dado("criar um personagem")
	public void criarUmPersonagem() {
		response = requestSpecification
			.body(personagensDto)
		.when()
			.basePath("/v1/personagens")
			.log()
			.all()
			.post();
	}
	
	@Dado("alterar um personagem {string}")
	public void alterarUmPersonagem(String id) {
		response = requestSpecification
			.body(personagensDto)
		.when()
			.basePath("/v1/personagens/"+ id)
			.log()
			.all()
			.put();
	}

	@Dado("deletar um personagem {string}")
	public void deletarUmPersonagem(String id) {
		response = requestSpecification
		.when()
			.basePath("/v1/personagens/" + id)
			.log()
			.all()
			.delete();
	}	

	@Entao("validar o status code {int}")
	public void validarOStatusCode(Integer statusCode) {
		response
		.then()
			.statusCode(statusCode);
	}
	
}
