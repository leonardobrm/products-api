# Products-api

## Descrição

Este é uma API rest em Quarkus para gestão de produtos no banco de dados. Ele fornece endpoints para criar, atualizar, listar, listar não vencidos, listar por ID e excluir registros.

## Tecnologias Utilizadas

- Quarkus
- ORM Panache
- PostgreSQL
- Docker e Docker Compose (para desenvolvimento)
- Maven
- Lombok
- Jacoco
- Flyway

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em seu sistema:

- Java 17
- Maven
- Docker e Docker Compose (para execução de banco de dados)

## Executando o Projeto

### Localmente

1. **Clone o Repositório:**
    ```bash
    git clone https://github.com/leonardobrm/products-api
    ```

2. **Navegue até o Diretório do Projeto:**
    ```bash
    cd project-api
    ```

3. **Execute o Aplicativo Quarkus:**
    ```bash
    ./mvnw quarkus:dev
    ```

### Com Docker

1. Certifique-se de ter o Docker e o Docker Compose instalados.

2. Execute o seguinte comando na raiz do projeto:
    ```bash
    docker-compose up -d
    ```

## Uso da API

A API expõe os seguintes endpoints:

- **Criar:**
    ```bash
    POST /v1/product
  
  {
    "name": "produto teste",
    "description": "produto teste",
    "quantity": 2,
    "expiry_date": "11-11-2024"
  }
    ```

- **Atualizar:**
    ```bash
    PUT /v1/product/{id}
  
  {
    "name": "produto teste",
    "description": "produto teste",
    "quantity": 2,
    "expiry_date": "11-11-2024"
  }
    ```

- **Listar Todos (paginado):**
    ```bash
    GET /v1/product?page=0&size=5
    ```

- **Listar Todos Válidos (paginado):**
    ```bash
    GET /v1/product/validos?page=1&size=3
    ```

- **Listar por ID:**
    ```bash
    GET /v1/product/{id}
    ```

- **Deletar:**
    ```bash
    DELETE /v1/producto/{id}
    ```

### Exemplos de Requisições

#### Criar um Novo Registro
```bash
curl --location 'http://localhost:8080/v1/product' \
--header 'Content-Type: application/json' \
--data '{
    "name": "produto teste",
    "description": "produto teste",
    "quantity": 1,
    "expiry_date": "12-11-2023"
}'
````
#### Atualizar um registro
```bash
curl --location --request PUT 'http://localhost:8080/v1/product/2' \
--header 'Content-Type: application/json' \
--data '{
    "name": "produto teste",
    "description": "teste",
    "quantity": 88,
    "expiry_date": "11-11-2024"
}'
```

#### Listar todos(paginado)
`````bash
curl --location 'http://localhost:8080/v1/product?page=0&size=10'
`````

#### Listar  todos válidos
`````bash
curl --location 'http://localhost:8080/v1/product/valid?page=0&size=10'
`````

#### Listar por id
`````bash
curl --location 'http://localhost:8080/v1/product/{id}'
`````

#### Deletar um registro
`````bash
curl --location --request DELETE 'http://localhost:8080/v1/product/1'
`````