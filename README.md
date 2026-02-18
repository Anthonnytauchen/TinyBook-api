Aqui está uma sugestão de README para o seu projeto **TinyBook-api**, estruturado com base nas tecnologias que identifiquei no seu repositório (Java, Spring Boot e PostgreSQL).

---

# TinyBook API

A **TinyBook API** é o back-end de um sistema de agendamentos simplificado, desenvolvido para facilitar a gestão de horários e reservas. Este projeto foi construído utilizando as melhores práticas de desenvolvimento com o ecossistema Spring.

## 🚀 Tecnologias Utilizadas

Este projeto utiliza as seguintes tecnologias e ferramentas:

* **Java 17** (ou versão superior)
* **Spring Boot 3**
* **Spring Data JPA**: Para persistência de dados.
* **PostgreSQL**: Banco de dados relacional.
* **Maven**: Gerenciador de dependências.
* **Spring Security**: (Se aplicável) Para autenticação e autorização.
* **Validation**: Para validação de dados de entrada.

## 📋 Funcionalidades (Exemplos)

* Cadastro e gerenciamento de usuários.
* Criação, leitura, atualização e exclusão (CRUD) de agendamentos.
* Listagem de horários disponíveis.
* Persistência em banco de dados relacional.

## 🔧 Configuração do Ambiente

Para rodar o projeto localmente, siga os passos abaixo:

### Pré-requisitos

* JDK 17 instalado.
* Maven instalado.
* PostgreSQL rodando localmente ou via Docker.

### Configuração do Banco de Dados

No arquivo `src/main/resources/application.properties`, configure as credenciais do seu banco de dados:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tinybook_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update

```

### Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/Anthonnytauchen/TinyBook-api.git

```


2. Entre na pasta do projeto:
```bash
cd TinyBook-api

```


3. Execute o projeto via Maven:
```bash
./mvnw spring-boot:run

```



## 🛣️ Endpoints Principais

| Método | Endpoint | Descrição |
| --- | --- | --- |
| `GET` | `/api/appointments` | Lista todos os agendamentos |
| `POST` | `/api/appointments` | Cria um novo agendamento |
| `GET` | `/api/users` | Lista usuários do sistema |


