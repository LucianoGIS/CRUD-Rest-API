## Membros do Grupo

[<img src="https://github.com/ThiagoWaldrich.png" width="60" style="border-radius: 30px;">](https://github.com/ThiagoWaldrich) [<img src="https://github.com/lucianoGIS.png" width="60" style="border-radius: 30px;">](https://github.com/lucianoGIS) [<img src="https://github.com/marcioscw.png" width="60" style="border-radius: 30px;">](https://github.com/marcioscw)


Este repositório contém um aplicativo simples Spring Boot que demonstra operações CRUD usando um banco de dados H2 em memória. O projeto foi criado para demonstrar como criar uma API Rest usando Spring Boot e Spring Data JPA.

## Tecnologias Utilizadas

- Spring Boot
- Spring Data JPA
- Banco de Dados H2
- Maven

## Contexto

Esta API foi desenvolvida como parte do projeto da disciplina Tópico Especiais 2 (TE 2) para o curso de ADS no IFS.

## Configuração

Para executar este projeto localmente, certifique-se de ter o Java e o Maven instalados em sua máquina. Siga as etapas abaixo:

1. Clone o repositório:

   ```bash
   git clone https://github.com/LucianoGIS/CRUD-Rest-API.git
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd CRUD-Rest-API
   ```

3. Compile e execute a aplicação:

   ```bash
   mvn spring-boot:run
   ```

   A aplicação estará acessível em [http://localhost:8080]

## Pontos de Acesso da API

- **Criar:** `POST /lancamentos/create`
- **Ler:** 
  - `GET /lancamentos` (Obter todos)
  - `GET /lancamentos/{id}` (Obter por ID)
- **Atualizar:** `PUT /lancamentos/update/{id}`
- **Excluir:** `DELETE /lancamentos/delete/{id}`

## Exemplos

- **Criar:**
  ```bash
  curl -X POST -H "Content-Type: application/json" -d '{"field1":"value1", "field2":"value2"}' http://localhost:8080/lancamentos/create
  ```

- **Ler Todos:**
  ```bash
  curl http://localhost:8080/lancamentos
  ```

- **Ler por ID:**
  ```bash
  curl http://localhost:8080/lancamentos/{id}
  ```

- **Atualizar:**
  ```bash
  curl -X PUT -H "Content-Type: application/json" -d '{"field1":"updatedValue"}' http://localhost:8080/lancamentos/update/{id}
  ```

- **Excluir:**
  ```bash
  curl -X DELETE http://localhost:8080/lancamentos/delete/{id}
  ```
