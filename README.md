<p align="center">
  <a href="" rel="noopener">
 <img width=200px height=200px src="https://i.imgur.com/6wj0hh6.jpg" alt="Contract First"></a>
</p>

<h3 align="center">Contract First</h3>

<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)]()
[![GitHub Pull Requests](https://img.shields.io/github/issues-pr/kylelobo/The-Documentation-Compendium.svg)](https://github.com/kylelobo/The-Documentation-Compendium/pulls)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](/LICENSE)

</div>

---

<p align="center">
    A metodologia sugerida é para gerar API's através de ferramentas visuais, afim de minimizar o tempo de desenvolvimento de novas API's e aplicações clientes que consomem as API's.
    <br>
    O fluxo de criação das APIs e alterações devem ser práticos, gerando facilidade e flexibilidade.     
</p>

## 📝 Table of Contents

- [About](#about)
- [Getting Started](#getting_started)
- [Usage](#usage)
- [Built Using](#built_using)

## 🧐 About <a name = "about"></a>

O projeto busca demonstrar como desenvolver uma aplicação baseada em Contract First. <br>
Inicialmente trabalharemos com Java e Springboot para gerar API's através de contratos.

## 🏁 Getting Started <a name = "getting_started"></a>

### Prerequisites
- Docker
- Maven

### Installing

Confirme se está na pasta base do sistema na linha de comando.

Execute o comando abaixo para criar os modelos e interfaces para os endpoints.

```
mvn clean install
```

Para subir o banco de dados utilizaremos do Docker, seu utilitário docker-compose irá permitir subirmos o banco de dados já configurado.
```
docker-compose up -d
```

Agora estamos pronto para subirmos a aplicação



## 🎈 Usage <a name="usage"></a>

Agora é só executar o comando
```
mvn spring-boot:run
```

Sua aplicação ficará disponível em http://localhost:8080

## ⛏️ Built Using <a name = "built_using"></a>

- [APICRIO](https://studio.apicur.io/) - Criação do contrato Open API
    - [Swagger](https://editor-next.swagger.io/) - Validação de contratos Open API
    - [Stoplight](https://stoplight.io/) - Criação do contrato Open API
- [Postman](https://www.postman.com/) - Cliente para efetuar chamadas
- [Spring Initializr](https://start.spring.io/) - Criação do projeto inicial
- [OpenAPI Generator](https://openapi-generator.tech/) - Geração de códigos
- [Maven](https://maven.apache.org/) - Gerenciamento de ferramentas do ciclo de vida do desenvolvimento
- [Docker](https://www.docker.com/) - Containers para subir a infraestrutura da aplicação


## Obrigado pela Visita!!!