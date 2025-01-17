# Forum Hub

Bem-vindo ao ForumHub, uma API REST construída para gerenciar tópicos e discussões em fóruns. Este projeto foi desenvolvido com o objetivo de praticar conceitos de desenvolvimento backend, arquitetura REST e integrações com banco de dados.

## Funcionalidades

1. **Cadastro de Tópicos**: Permite criar tópicos com título, mensagem, autor e curso.

2. **Listagem de Tópicos**: Endpoint para listar todos os tópicos cadastrados.

3. **Detalhes de um Tópico**: Endpoint para recuperar informações detalhadas de um tópico pelo seu ID.

4. **Exclusão de um tópico**: Endpoint para excluir um tópico utilizando o ID como base de busca.

5. **Autenticação JWT**: Garante a segurança da API com autenticação baseada em tokens.


## Tecnologias utilizadas

<p align="left">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=java,spring,maven,postgresql&perline=9" />
  </a>
</p>

## Rotas disponíveis

1. Cadastro de Usuário
   - Endpoint: /cadastro
   - Método: POST
   - Corpo da requisição:
    ```json
      {
        "nome": "nome do usuario",
        "email": "email do usuario",
        "senha": "senha do usuario"
      }
    ```
   _**Resposta**: 200 Ok com o usuário cadastrado_


2. Autenticação JWT
   - Endpoint: /login
   - Método: POST
   - Corpo da requisição:
    ```json
      {
        "email": "email do usuario",
        "senha": "senha do usuario"
      }
    ```
   _**Resposta**: 200 Ok com o usuário logado_
    - Observação: Todos os endpoints que exigem autenticação devem incluir o token JWT no cabeçalho da requisição com o nome Authorization e o token no prefixo Bearer. Exemplo:
   ```
        Authorization: <token_jwt>
   ```


3. Cadastro de Tópicos
   - Endpoint: /topicos
   - Método: POST
   - Corpo da requisição:
   ```json
    {
        "titulo": "Título do tópico",
        "mensagem": "Mensagem do tópico",
        "autor": "Nome do autor",
        "curso": "Nome do curso"
    }
   ```
   _**Resposta**: 201 Created com o ID do tópico criado_


4. Listagem de Tópicos
   - Endpoint: /topicos
   - Método: GET
   - **Resposta**: 200 OK com uma lista de tópicos em formato JSON
   ```json
      "content": [
            {
                "id": 1,
                "titulo": "Dúvida Spring Boot",
                "mensagem": "Como implementar validação?",
                "dataCriacao": "16/01/2025 13:11",
                "status": "NAO_RESPONDIDO",
                "autor": "fern",
                "curso": "Spring Boot"
            },
            {
                "id": 2,
                "titulo": "Dúvidas sobre supressão de mana",
                "mensagem": "depois de 2 mil anos fazendo isso, percebi que não estou mais aguentando suprimir minha mana",
                "dataCriacao": "16/01/2025 13:16",
                "status": "NAO_RESPONDIDO",
                "autor": "frieren",
                "curso": "Magia ancestral"
            }
       ]
    ```


5. Detalhes de um Tópico
   - Endpoint: /topicos/{id}
   - Método: GET
   - Resposta: 200 OK com as informações detalhadas do tópico em formato JSON
   ```json
    {
      "id": 2,
      "titulo": "Dúvidas sobre supressão de mana",
      "mensagem": "depois de 2 mil anos fazendo isso, percebi que não estou mais aguentando suprimir minha mana",
      "dataCriacao": "16/01/2025 13:16",
      "status": "NAO_RESPONDIDO",
      "autor": "frieren",
      "curso": "Magia ancestral"
    }
    ```

6. Atualizar um Tópico
    - Endpoint: /topicos
    - Método: PUT
    - Corpo da requisição:
   ```json
    {
      "id": id_topico,
      "titulo": "Alterar título do tópico",
      "mensagem": "Alterar mensagem do tópico",
      "curso": "Alterar nome do curso"
    }
    ```
    _**Resposta**: 200 Ok com informações atualizadas_


7. Exclusão de um Tópico
   - Endpoint: /topicos/{id}
   - Método: DELETE
   - **Resposta**: 204 No Content se o tópico for excluído com sucesso

## Como Executar o Projeto
- Java JDK 17 ou superior.
- Gerenciador de pacotes maven instalado.
- Banco de dados configurado (por exemplo: MySQL ou PostgreSQL).
- Ferramenta para teste de Api (por exemplo: Postman ou Insomnia)

## Passos para Execução

1. Clone o repositório:
    ```bash
    git clone https://github.com/lucca16bit/spring-forum-hub
    cd spring-forum-hub
    ```
2. Configure o banco de dados:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/forum_hub
    spring.datasource.username=seu-usuario
    spring.datasource.password=sua-senha
    spring.jpa.hibernate.ddl-auto=update
    api.security.token.secret=sua-senha-jwt
    ```
3. Compile e execute o projeto:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

<div align="center">
  <img src="src/main/resources/assets/badge-spring.png" alt="badge literalura" width="300">
</div>