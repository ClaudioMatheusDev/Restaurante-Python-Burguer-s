# 🍔 Python Burguer's - Sistema de Gestão de Restaurante

Sistema web completo para gestão de restaurante desenvolvido com Spring Boot, MySQL e Thymeleaf.

## 📋 Funcionalidades

- ✅ Cadastro e listagem de cardápio
- ✅ Cadastro de clientes
- ✅ Sistema de encomendas
- ✅ Formulário de contato
- ✅ Páginas informativas (Sobre, Contato)
- ✅ Interface responsiva com Bootstrap 5

## 🛠️ Tecnologias Utilizadas

- **Backend:** Spring Boot 3.5.6
- **Frontend:** Thymeleaf, Bootstrap 5.3.3
- **Banco de Dados:** MySQL 8.0
- **Build Tool:** Maven
- **Java:** 21

## 📦 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- JDK 21 ou superior
- MySQL 8.0 ou superior
- Maven 3.6 ou superior

## 🚀 Instalação e Configuração

### 1. Clone o repositório (se aplicável)
```bash
git clone https://github.com/ClaudioMatheusDev/Restaurante-Python-Burguer-s
cd demo
```

### 2. Configure o Banco de Dados

Execute o script SQL localizado em `database/restaurantedb.sql`:

```bash
mysql -u root -p < database/restaurantedb.sql
```

Ou importe manualmente no phpMyAdmin/MySQL Workbench.

### 3. Configure as credenciais do banco

Edite o arquivo `src/main/resources/application.properties` se necessário:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/restaurantedb
spring.datasource.username=root
spring.datasource.password=
```

### 4. Compile e execute o projeto

```bash
# Compilar
mvn clean install

# Executar
mvn spring-boot:run
```

Ou use o wrapper do Maven:

```bash
# Windows
.\mvnw.cmd spring-boot:run

# Linux/Mac
./mvnw spring-boot:run
```

### 5. Acesse a aplicação

Abra seu navegador e acesse: `http://localhost:8080`

## 📂 Estrutura do Projeto

```
demo/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── controller/
│   │   │   │   └── HomeController.java
│   │   │   ├── model/
│   │   │   │   ├── Cardapio.java
│   │   │   │   ├── Cliente.java
│   │   │   │   ├── Conexao.java
│   │   │   │   ├── Email.java
│   │   │   │   ├── Encomenda.java
│   │   │   │   └── Pessoa.java
│   │   │   └── DemoApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── templates/
│   │           ├── Cadastrocardapio.html
│   │           ├── cardapio.html
│   │           ├── cliente.html
│   │           ├── contato.html
│   │           ├── encomenda.html
│   │           ├── error.html
│   │           ├── index.html
│   │           ├── listaencomendas.html
│   │           ├── sobre.html
│   │           ├── sucessocardapio.html
│   │           ├── sucessoemailenviado.html
│   │           └── sucessoencomenda.html
│   └── test/
├── database/
│   └── restaurantedb.sql
├── pom.xml
└── README.md
```

## 🗄️ Estrutura do Banco de Dados

O sistema utiliza 4 tabelas principais:

- **cardapios:** Armazena os itens do cardápio
- **clientes:** Cadastro de clientes
- **encomendas:** Registra os pedidos realizados
- **contatos:** Mensagens de contato dos visitantes

## 🌐 Rotas Disponíveis

| Rota | Método | Descrição |
|------|--------|-----------|
| `/` | GET | Página inicial |
| `/cardapio` | GET | Lista o cardápio |
| `/Cadastrocardapio` | GET | Formulário de cadastro de lanche |
| `/card` | POST | Processa cadastro de lanche |
| `/cliente` | GET | Formulário de cadastro de cliente |
| `/client` | POST | Processa cadastro de cliente |
| `/Encomenda` | GET | Formulário de encomenda |
| `/enco` | POST | Processa encomenda |
| `/encomendas` | GET | Lista todas as encomendas |
| `/contato` | GET | Formulário de contato |
| `/contact` | POST | Processa contato |
| `/sobre` | GET | Página sobre o restaurante |

## 🎨 Interface

O sistema utiliza Bootstrap 5 para uma interface moderna e responsiva, com:

- Menu de navegação consistente em todas as páginas
- Cards para exibição de informações
- Formulários estilizados
- Tabelas responsivas
- Badges para status de encomendas

## 📝 Melhorias Implementadas

- ✅ Correção da estrutura de pacotes (Model → model)
- ✅ Adição de construtor vazio nas classes modelo
- ✅ Implementação completa do sistema de encomendas
- ✅ Criação de métodos de busca (buscarTodos, buscarPorId)
- ✅ Normalização de todos os templates HTML
- ✅ Configuração adequada do application.properties
- ✅ Atualização do banco de dados com tabelas faltantes
- ✅ Página de erro personalizada
- ✅ Links de navegação funcionais

## 🔧 Possíveis Melhorias Futuras

- [ ] Implementar JPA/Hibernate em vez de JDBC puro
- [ ] Adicionar autenticação e autorização
- [ ] Implementar carrinho de compras
- [ ] Adicionar upload de imagens para os lanches
- [ ] Sistema de avaliações
- [ ] Painel administrativo
- [ ] API REST para integração mobile
- [ ] Sistema de pagamento

## 📄 Licença

Este projeto é de código aberto para fins educacionais.

---

**Python Burguer's** - O sabor do código em cada mordida! 🍔💻
