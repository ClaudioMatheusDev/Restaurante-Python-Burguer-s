# 🚀 Guia de Inicialização Rápida - Python Burguer's

## Passo 1: Preparar o Banco de Dados

### Opção A: Via phpMyAdmin
1. Abra phpMyAdmin (geralmente em `http://localhost/phpmyadmin`)
2. Clique em "Importar"
3. Selecione o arquivo `database/restaurantedb.sql`
4. Clique em "Executar"

## Passo 2: Verificar Configurações

Abra `src/main/resources/application.properties` e confirme:

```properties
spring.datasource.username=root
spring.datasource.password=
```

Se sua senha do MySQL for diferente, altere aqui!

## Passo 3: Executar a Aplicação

### Windows (PowerShell):
```powershell
.\mvnw.cmd spring-boot:run
```

### Ou com Maven instalado:
```bash
mvn spring-boot:run
```

## Passo 4: Acessar

Aguarde a mensagem: `Started DemoApplication in X seconds`

Então abra seu navegador em: **http://localhost:8080**

## 🎯 Teste Rápido das Funcionalidades

### 1. Cadastrar Cliente
- Vá em: http://localhost:8080/cliente
- Preencha: Nome, Email, Telefone
- Clique em "Enviar"

### 2. Cadastrar Lanche
- Vá em: http://localhost:8080/Cadastrocardapio
- Preencha: Nome (ex: X-Tudo), Composição, Preço
- Clique em "Enviar"

### 3. Ver Cardápio
- Vá em: http://localhost:8080/cardapio
- Veja os lanches cadastrados

### 4. Fazer Encomenda
- Vá em: http://localhost:8080/Encomenda
- Selecione Cliente e Lanche
- Defina quantidade
- Clique em "Fazer Encomenda"

### 5. Ver Encomendas
- Vá em: http://localhost:8080/encomendas
- Veja todas as encomendas com valores calculados

## ❌ Problemas Comuns

### Erro: "Cannot connect to database"
- ✅ Verifique se o MySQL está rodando
- ✅ Confirme usuário e senha em `application.properties`
- ✅ Certifique-se que o banco `restaurantedb` foi criado

### Erro: "Table doesn't exist"
- ✅ Execute o script SQL em `database/restaurantedb.sql`

### Erro: "Port 8080 already in use"
- ✅ Pare outros servidores na porta 8080
- ✅ Ou altere a porta em `application.properties`:
  ```properties
  server.port=8081
  ```

### Erro de compilação
- ✅ Certifique-se de ter o JDK 21 instalado
- ✅ Execute: `mvn clean install`

## 📱 URLs Principais

| Página | URL |
|--------|-----|
| **Início** | http://localhost:8080/ |
| **Cardápio** | http://localhost:8080/cardapio |
| **Cadastro Cliente** | http://localhost:8080/cliente |
| **Cadastro Lanche** | http://localhost:8080/Cadastrocardapio |
| **Fazer Encomenda** | http://localhost:8080/Encomenda |
| **Ver Encomendas** | http://localhost:8080/encomendas |
| **Sobre** | http://localhost:8080/sobre |
| **Contato** | http://localhost:8080/contato |

## 🛑 Para Parar a Aplicação

Pressione `Ctrl + C` no terminal onde a aplicação está rodando.

## ✅ Checklist de Verificação

- [ ] MySQL instalado e rodando
- [ ] Banco `restaurantedb` criado com as tabelas
- [ ] JDK 21+ instalado
- [ ] Maven instalado (ou usar mvnw)
- [ ] Credenciais do banco configuradas
- [ ] Porta 8080 disponível
- [ ] Aplicação compilada sem erros
- [ ] Navegador acessando http://localhost:8080

## 🎉 Tudo Pronto!

Se todos os passos funcionaram, você verá a página inicial do **Python Burguer's**!

Aproveite para testar todas as funcionalidades! 🍔💻
