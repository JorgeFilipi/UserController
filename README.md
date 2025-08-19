# 🔐 User Controller - Sistema de Gerenciamento de Usuários

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://openjdk.java.net/projects/jdk/21/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.4-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Spring Security](https://img.shields.io/badge/Spring%20Security-6.0-blue.svg)](https://spring.io/projects/spring-security)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue.svg)](https://www.postgresql.org/)
[![JWT](https://img.shields.io/badge/JWT-Auth0-yellow.svg)](https://jwt.io/)
[![Maven](https://img.shields.io/badge/Maven-3.9+-red.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

> **Sistema completo de gerenciamento de usuários com autenticação JWT e controle de roles usando Spring Boot Security**

## 📋 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Funcionalidades](#-funcionalidades)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Arquitetura](#-arquitetura)
- [Instalação e Configuração](#-instalação-e-configuração)
- [API Endpoints](#-api-endpoints)
- [Segurança](#-segurança)
- [Testes](#-testes)
- [Deploy](#-deploy)
- [Contribuição](#-contribuição)
- [Licença](#-licença)

## 🎯 Sobre o Projeto

Este projeto é um sistema robusto de gerenciamento de usuários desenvolvido em **Spring Boot** com foco em **segurança** e **escalabilidade**. Implementa autenticação via **JWT (JSON Web Tokens)** e controle de acesso baseado em roles, sendo ideal para portfólios e aplicações que necessitam de um sistema de usuários completo.

### ✨ Principais Características

- 🔐 **Autenticação JWT** com tokens seguros
- 👥 **Controle de Roles** (ADMIN e USER)
- 🔒 **Criptografia de Senhas** com BCrypt
- 📊 **Paginação** de resultados
- ✅ **Validação Completa** de dados
- 🚀 **API RESTful** bem documentada
- 🛡️ **Segurança Robusta** com Spring Security

## 🚀 Funcionalidades

| Funcionalidade | Status | Descrição |
|----------------|--------|-----------|
| ✅ Cadastro de Usuários | Implementado | Criação de usuários com validação |
| ✅ Autenticação JWT | Implementado | Login seguro com tokens |
| ✅ Controle de Roles | Implementado | ADMIN e USER com permissões específicas |
| ✅ Criptografia BCrypt | Implementado | Senhas criptografadas |
| ✅ CRUD Completo | Implementado | Criar, ler, atualizar e deletar |
| ✅ Paginação | Implementado | Listagem paginada de usuários |
| ✅ Validação de Dados | Implementado | Validação robusta de entrada |
| ✅ Tratamento de Erros | Implementado | Respostas de erro padronizadas |

## 🛠️ Tecnologias Utilizadas

### Backend
- **[Java 21](https://openjdk.java.net/projects/jdk/21/)** - Linguagem principal
- **[Spring Boot 3.5.4](https://spring.io/projects/spring-boot)** - Framework principal
- **[Spring Security 6](https://spring.io/projects/spring-security)** - Segurança e autenticação
- **[Spring Data JPA](https://spring.io/projects/spring-data-jpa)** - Persistência de dados
- **[PostgreSQL](https://www.postgresql.org/)** - Banco de dados
- **[JWT (Auth0)](https://jwt.io/)** - Tokens de autenticação
- **[Lombok](https://projectlombok.org/)** - Redução de boilerplate
- **[Maven](https://maven.apache.org/)** - Gerenciamento de dependências

### Ferramentas
- **[Docker](https://www.docker.com/)** - Containerização (opcional)
- **[Postman](https://www.postman.com/)** - Testes de API
- **[Git](https://git-scm.com/)** - Controle de versão

## 🏗️ Arquitetura

```
src/main/java/com/dev_jdias/userController/
├── 📁 controller/                    # Camada de Controle
│   ├── 🔐 AuthenticatioController.java    # Autenticação
│   └── 👥 UserController.java             # CRUD de Usuários
├── 📁 infra/security/                # Infraestrutura de Segurança
│   ├── ⚙️ SecurityConfigurations.java     # Configurações
│   └── 🔍 SecurityFilter.java             # Filtro JWT
├── 📁 services/                      # Camada de Serviços
│   ├── 🔑 AuthorizationServise.java       # Autorização
│   └── 🎫 TokenService.java               # Geração/Validação JWT
└── 📁 user/                          # Domínio de Usuário
    ├── 📁 dto/                       # Data Transfer Objects
    │   ├── 📝 DadosCadastro.java          # DTO de Cadastro
    │   └── 📋 DadosDetalhamentoUser.java  # DTO de Resposta
    ├── 🏷️ Role.java                       # Enum de Roles
    ├── 👤 User.java                       # Entidade Usuário
    └── 💾 UserRepository.java             # Repositório JPA
```

### Padrões Utilizados

- **MVC (Model-View-Controller)**
- **Repository Pattern**
- **DTO Pattern**
- **JWT Authentication**
- **Role-Based Access Control (RBAC)**

## ⚙️ Instalação e Configuração

### Pré-requisitos

- Java 21 ou superior
- PostgreSQL 12 ou superior
- Maven 3.9 ou superior
- Git

### 1. Clone o Repositório

```bash
git clone https://github.com/seu-usuario/userController.git
cd userController
```

### 2. Configure o Banco de Dados

```sql
-- Conecte ao PostgreSQL e execute:
CREATE DATABASE usercontroller;
CREATE USER usercontroller WITH PASSWORD 'sua_senha';
GRANT ALL PRIVILEGES ON DATABASE usercontroller TO usercontroller;
```

### 3. Configure as Variáveis de Ambiente

Copie o arquivo de exemplo e configure suas variáveis:

```bash
cp env.example .env
```

Edite o arquivo `.env`:

```env
# Configurações do Banco de Dados PostgreSQL
DB_URL=jdbc:postgresql://localhost:5432/usercontroller
DB_USER=usercontroller
DB_PASSWORD=sua_senha_aqui

# Chave secreta para JWT (GERE UMA CHAVE SEGURA!)
SECRET_TOKEN=sua_chave_secreta_jwt_muito_segura_aqui_use_uma_chave_com_pelo_menos_32_caracteres
```

### 4. Execute o Projeto

```bash
# Compilar o projeto
mvn clean compile

# Executar a aplicação
mvn spring-boot:run
```

A aplicação estará disponível em: **http://localhost:8080**

## 📡 API Endpoints

### 🔐 Autenticação

#### POST `/auth/login`
Faz login e retorna um token JWT.

**Request:**
```json
{
  "email": "admin@example.com",
  "password": "123456"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbkBleGFtcGxlLmNvbSIsImlzcyI6IlVzZXJDb250cm9sbGVyIiwiaWQiOjEsImV4cCI6MTcwMzE2ODAwMH0..."
}
```

### 👥 Usuários

#### POST `/user` (ADMIN)
Cadastra um novo usuário.

**Request:**
```json
{
  "email": "user@example.com",
  "password": "123456",
  "role": "USER"
}
```

**Response:**
```json
{
  "id": 2,
  "email": "user@example.com",
  "role": "USER",
  "active": true
}
```

#### GET `/user` (USER)
Lista todos os usuários com paginação.

**Query Parameters:**
- `page`: Número da página (padrão: 0)
- `size`: Tamanho da página (padrão: 10)
- `sort`: Campo para ordenação

**Response:**
```json
{
  "content": [
    {
      "id": 1,
      "email": "admin@example.com",
      "role": "ADMIN",
      "active": true
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10
  },
  "totalElements": 1,
  "totalPages": 1
}
```

#### GET `/user/{id}` (USER)
Busca um usuário específico por ID.

#### DELETE `/user/{id}` (ADMIN)
Remove um usuário por ID.

## 🔐 Segurança

### Roles e Permissões

| Role | Permissões |
|------|------------|
| **ADMIN** | Acesso total ao sistema (CRUD completo) |
| **USER** | Acesso de leitura aos usuários |

### Autenticação JWT

- **Algoritmo**: HMAC256
- **Expiração**: 2 horas
- **Issuer**: UserController
- **Claims**: email, id, exp

### Criptografia

- **Algoritmo**: BCrypt
- **Salt Rounds**: 10 (padrão Spring Security)

### Headers de Segurança

Para acessar endpoints protegidos:

```
Authorization: Bearer <seu_token_jwt>
Content-Type: application/json
```

## 🧪 Testes

### Testando com cURL

#### 1. Criar um usuário admin

```bash
curl -X POST http://localhost:8080/user \
  -H "Content-Type: application/json" \
  -d '{
    "email": "admin@example.com",
    "password": "123456",
    "role": "ADMIN"
  }'
```

#### 2. Fazer login

```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "admin@example.com",
    "password": "123456"
  }'
```

#### 3. Usar o token para acessar endpoints protegidos

```bash
curl -X GET http://localhost:8080/user \
  -H "Authorization: Bearer <seu_token_aqui>"
```

### Testando com Postman

1. Importe a coleção do Postman (disponível em `/docs/postman`)
2. Configure as variáveis de ambiente
3. Execute os testes automatizados

## 🚀 Deploy

### Docker (Recomendado)

```bash
# Build da imagem
docker build -t usercontroller .

# Executar container
docker run -p 8080:8080 \
  -e DB_URL=jdbc:postgresql://host.docker.internal:5432/usercontroller \
  -e DB_USER=usercontroller \
  -e DB_PASSWORD=sua_senha \
  -e SECRET_TOKEN=sua_chave_secreta \
  usercontroller
```

### Deploy Manual

1. Configure as variáveis de ambiente no servidor
2. Execute: `mvn clean package`
3. Execute: `java -jar target/userController-0.0.1-SNAPSHOT.jar`

### Plataformas de Deploy

- ✅ **Heroku**
- ✅ **AWS EC2**
- ✅ **Google Cloud Platform**
- ✅ **Azure**
- ✅ **DigitalOcean**

## 📊 Monitoramento

### Logs

A aplicação gera logs estruturados para monitoramento:

```bash
# Visualizar logs em tempo real
tail -f logs/application.log
```

### Métricas

- **Health Check**: `/actuator/health`
- **Info**: `/actuator/info`
- **Metrics**: `/actuator/metrics`

## 🤝 Contribuição

Contribuições são sempre bem-vindas! Para contribuir:

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

### Padrões de Código

- Siga as convenções do Java
- Use nomes descritivos para variáveis e métodos
- Adicione comentários quando necessário
- Mantenha a cobertura de testes alta

## 📝 Validações

### Dados de Entrada

- ✅ **Email**: Formato válido e único
- ✅ **Senha**: Mínimo 6 caracteres
- ✅ **Role**: ADMIN ou USER obrigatório
- ✅ **Token JWT**: Validação de assinatura e expiração

### Respostas de Erro

```json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Email já cadastrado",
  "path": "/user"
}
```

## 📄 Licença

Este projeto está sob a licença **MIT**. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👨‍💻 Autor

**Seu Nome**
- GitHub: [@seu-usuario](https://github.com/seu-usuario)
- LinkedIn: [Seu LinkedIn](https://linkedin.com/in/seu-perfil)
- Email: seu-email@example.com

## 🙏 Agradecimentos

- [Spring Boot](https://spring.io/projects/spring-boot) pela excelente documentação
- [Auth0](https://auth0.com/) pela biblioteca JWT
- [PostgreSQL](https://www.postgresql.org/) pelo banco de dados robusto

---

⭐ **Se este projeto te ajudou, considere dar uma estrela!** 