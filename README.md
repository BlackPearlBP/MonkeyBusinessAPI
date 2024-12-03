# :monkey_face: MonkeyBusinessAPI

## :memo: Descrição

A MonkeyBusinessAPI oferece informações sobre diversas espécies de primatas, permitindo que os usuários consultem características de cada espécie, filtrem por habitat, descubram a dieta típica de cada uma e também realizem operações CRUD (Create, Read, Update & Delete), sobre o banco de dados de espécies. A API é voltada para fins educacionais e de pesquisa, fornecendo dados simples e acessíveis para quem quer aprender mais sobre esses animais.

## Funcionalidades

- **Listar todos os primatas**: Retorna uma lista com todos os primatas, com uma opção de filtragem por habitat e dieta.
- **Buscar primata por nome**: Busca informações sobre um primata específico filtrado por seu nome.
- **Adicionar um novo primata**: Permite adicionar um novo primata ao banco de dados.
- **Atualizar dados existentes**: Permite atualizar informações de um primata existente.
- **Deletar um primata**: Deleta um primata da lista.

## Estrutura

O projeto é estruturado em:

- **config**: Contém as configurações da API, como porta e banco de dados.

- **controllers**: Contém as classes que lidam com as requisições HTTP, realizando operações CRUD.

- **models**: Contém as classes que representam os primatas, com suas características e métodos

- **services**: Contém as classes que realizam operações de banco de dados.

- **resources**: Contém propriedades da aplicação.

## Tecnologias

- **Linguagem**: Java v. 17.0.10 >
- **Framework**: Spring Boot v. 2.5.4 
- **Gerenciador de Dependências**: Maven v. 3.3.6
- **Ambiente de Desenvolvimento**: Visual Studio Code (VSCode) v. 


## Como Executar o Projeto

**1. Clone ou baixe o zip do repositório (no caso do zip, descompacte a pasta).**
**2. Instale as dependências necessárias.**
**3. Configure o banco de dados corretamente.**
**4. Execute o comando 'mvn spring-boot:run' para iniciar a aplicação.**
**5. Acessa a API em http://localhost:8080/api/primates**

## Licença

Este projeto está licenciado sob a MIT License.

Projeto com fins educativos, sinta-se à vontade para modificar qualquer parte do README para atender suas necessidades.