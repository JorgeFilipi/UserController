# 🚀 Guia de Início Rápido - User Controller

Este guia te ajudará a configurar e executar o projeto em menos de 5 minutos!

## ⚡ Configuração Rápida

### 1. Pré-requisitos
- Java 21
- PostgreSQL
- Maven

### 2. Clone e Configure

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/userController.git
cd userController

# Configure as variáveis de ambiente
cp env.example .env
# Edite o arquivo .env com suas configurações
```

### 3. Banco de Dados

```sql
-- Execute no PostgreSQL
CREATE DATABASE usercontroller;
```

### 4. Execute

```bash
# Compile e execute
mvn spring-boot:run
```

🎉 **Pronto!** A aplicação estará rodando em `http://localhost:8080`

## 🧪 Teste Rápido

### 1. Criar um usuário admin
```bash
curl -X POST http://localhost:8080/user \
  -H "Content-Type: application/json" \
  -d '{
    "email": "admin@example.com",
    "password": "123456",
    "role": "ADMIN"
  }'
```

### 2. Fazer login
```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "admin@example.com",
    "password": "123456"
  }'
```

### 3. Usar o token retornado para acessar endpoints protegidos

## 🐳 Com Docker (Ainda mais rápido!)

```bash
# Execute tudo com Docker Compose
docker-compose up -d

# A aplicação estará disponível em http://localhost:8080
```

## 📚 Próximos Passos

- Leia o [README.md](README.md) completo
- Importe a [coleção do Postman](docs/postman-collection.json)
- Explore os endpoints da API
- Personalize conforme suas necessidades

## 🆘 Problemas Comuns

### Erro de conexão com banco
- Verifique se o PostgreSQL está rodando
- Confirme as credenciais no arquivo `.env`

### Erro de compilação
- Verifique se está usando Java 21
- Execute `mvn clean compile`

### Token inválido
- Tokens expiram em 2 horas
- Faça login novamente para obter um novo token

## 📞 Suporte

- 📖 [Documentação Completa](README.md)
- 🐛 [Reportar Bug](https://github.com/seu-usuario/userController/issues)
- 💡 [Solicitar Feature](https://github.com/seu-usuario/userController/issues)

---

⭐ **Gostou? Deixe uma estrela no repositório!**
