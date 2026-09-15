# 🏡 Staybook API

API REST para gerenciamento de acomodações, desenvolvida com **Java 17** e **Spring Boot**, aplicando princípios de **Clean Architecture** para separar regras de negócio, casos de uso e infraestrutura.

O projeto foi criado com foco no desenvolvimento Backend, boas práticas de organização, persistência com PostgreSQL e documentação de APIs com Swagger/OpenAPI.

## 🚀 Funcionalidades

- Cadastro de acomodações
- Busca de acomodação por ID
- Listagem de todas as acomodações
- Busca por tipo de acomodação
- Atualização de acomodações
- Exclusão de acomodações
- Geração automática de identificador no formato `STAY-XXXXXXXX`
- Status inicial automático como `DISPONIVEL`
- Data de criação gerada automaticamente
- Validação de endereço duplicado
- Busca por tipo ignorando maiúsculas e minúsculas
- Tratamento global de exceções
- Documentação interativa com Swagger/OpenAPI

## 🏗️ Arquitetura

O projeto utiliza uma organização inspirada em **Clean Architecture**, mantendo o núcleo da aplicação independente de frameworks e detalhes de infraestrutura.

```text
com.nisholas.staybook
├── core
│   ├── entities
│   ├── enums
│   ├── Exception
│   ├── gateway
│   └── usecases
│
└── infrastructure
    ├── BeanConfiguration
    ├── Converter
    ├── DTO
    ├── Exception
    ├── gateway
    ├── Mapper
    ├── persistence
    └── presentation
```

Fluxo principal da aplicação:

```text
Controller → Use Case → Gateway → Repository → PostgreSQL
```

## 🛠️ Tecnologias

- Java 17
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Hibernate
- PostgreSQL
- Flyway
- Docker / Docker Compose
- Maven
- Lombok
- Swagger / OpenAPI (Springdoc)
- Git e GitHub

## 🏠 Tipos de acomodação

A API trabalha atualmente com os seguintes tipos:

```text
APARTAMENTO
CASA
CABANA
POUSADA
ACAMPAMENTO
```

## 📡 Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/api/v1` | Cadastra uma acomodação |
| `GET` | `/api/v1` | Lista todas as acomodações |
| `GET` | `/api/v1/{id}` | Busca uma acomodação pelo ID |
| `GET` | `/api/v1/search?type=CASA` | Busca acomodações por tipo |
| `PUT` | `/api/v1/{id}` | Atualiza uma acomodação |
| `DELETE` | `/api/v1/{id}` | Exclui uma acomodação |

A busca por tipo aceita variações de maiúsculas e minúsculas, como `CASA`, `casa` ou `Casa`.

## 📥 Exemplo de cadastro

**POST `/api/v1`**

```json
{
  "nome": "Chalé Vista da Serra",
  "endereco": "Rua das Montanhas, 250 - Teresópolis, RJ",
  "descricao": "Chalé aconchegante com vista para a serra, lareira e estacionamento.",
  "preco": 390.00,
  "acomodacaoTipos": "CABANA"
}
```

Os campos `id`, `identificador`, `status` e `dataDeCriacao` são definidos automaticamente pela aplicação.

Exemplo de resposta:

```json
{
  "id": 1,
  "nome": "Chalé Vista da Serra",
  "endereco": "Rua das Montanhas, 250 - Teresópolis, RJ",
  "descricao": "Chalé aconchegante com vista para a serra, lareira e estacionamento.",
  "identificador": "STAY-A83F7C21",
  "preco": 390.00,
  "status": "DISPONIVEL",
  "acomodacaoTipos": "CABANA",
  "dataDeCriacao": "2026-09-15T10:00:00"
}
```

## ⚠️ Tratamento de erros

A API possui tratamento global de exceções.

### Acomodação não encontrada — `404 Not Found`

```json
{
  "status": 404,
  "error": "Not Found",
  "message": "A acomodação não foi encontrada ou não existe!",
  "path": "/api/v1/999"
}
```

### Endereço duplicado — `409 Conflict`

```json
{
  "status": 409,
  "error": "Conflict",
  "message": "O endereço informado já está em uso",
  "path": "/api/v1"
}
```

## 📚 Swagger / OpenAPI

Com a aplicação em execução, a documentação interativa pode ser acessada em:

```text
http://localhost:8080/swagger-ui.html
```

Especificação OpenAPI:

```text
http://localhost:8080/v3/api-docs
```

## 🐳 Executando o banco com Docker

Com Docker e Docker Compose instalados, execute na raiz do projeto:

```bash
docker compose up -d
```

O PostgreSQL será iniciado de acordo com as configurações presentes no `docker-compose.yaml` e nas variáveis de ambiente do projeto.

## ▶️ Executando a aplicação

Clone o repositório:

```bash
git clone https://github.com/Matheus-Nisholas/staybook-api.git
cd staybook-api
```

Configure as variáveis de ambiente necessárias para a conexão com o PostgreSQL e inicie o banco com Docker.

Depois execute:

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
mvnw.cmd spring-boot:run
```

A API estará disponível em:

```text
http://localhost:8080/api/v1
```

## 🗄️ Banco de dados e migrations

O projeto utiliza **PostgreSQL** para persistência e **Flyway** para versionamento do schema.

As migrations ficam em:

```text
src/main/resources/db/migration
```

Isso permite que a estrutura do banco seja criada e evolua de forma versionada e reproduzível.

## 📌 Regras de negócio implementadas

Ao criar uma acomodação, a aplicação:

1. verifica se o endereço já está em uso;
2. gera automaticamente um identificador `STAY-XXXXXXXX`;
3. define o status inicial como `DISPONIVEL`;
4. registra automaticamente a data de criação;
5. persiste a acomodação no PostgreSQL.

## 🔮 Próximas evoluções

A primeira versão da API está concluída. Algumas possibilidades de evolução são:

- sistema de reservas por período
- cadastro e autenticação de usuários
- Spring Security e JWT
- disponibilidade de acomodações por data
- avaliações de hospedagens
- testes unitários e de integração
- front-end consumindo a Staybook API

## 👨‍💻 Autor

**Matheus Nisholas**

Projeto desenvolvido para estudo e portfólio com foco em desenvolvimento **Java Backend**.
