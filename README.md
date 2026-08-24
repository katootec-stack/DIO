# Padrões de Projeto com Java e Spring Framework 🚀

Este repositório contém a solução desenvolvida para o Desafio de Projeto **"Design Patterns com Java: Dos Clássicos (GoF) ao Spring Framework"** da [Digital Innovation One (DIO)](https://www.dio.me/).

O projeto aborda a aplicação prática dos Padrões de Projeto (Design Patterns) mais relevantes, englobando tanto implementações puras (Design Patterns GoF clássicos) quanto a abordagem moderna e idiomática utilizando o **Spring Boot 3**.

---

## 🛠️ Tecnologias e Ferramentas

- **Java 21**
- **Spring Boot 3.2.3**
- **Spring Data JPA**
- **Spring Cloud OpenFeign** (integração declarativa com a API ViaCEP)
- **H2 Database** (banco de dados em memória)
- **Springdoc OpenAPI / Swagger UI** (documentação interativa de API)
- **Maven**

---

## 🧱 Padrões de Projeto Aplicados

### 1. Singleton
- **Java Puro**: `SingletonLazy`, `SingletonEager` e `SingletonLazyHolder`.
- **Spring Framework**: Gerenciamento automático do ciclo de vida e escopo dos componentes (`@Service`, `@Repository`, `@RestController`) via Spring IoC Container.

### 2. Strategy
- **Java Puro**: Interface `Comportamento` com implementações `ComportamentoNormal`, `ComportamentoDefensivo` e `ComportamentoAgressivo` controladas por `Robo`.
- **Spring Framework**: Interface `NotificationStrategy` (`EmailNotificationStrategy`, `SmsNotificationStrategy`, `WhatsappNotificationStrategy`) com resolução dinâmica em tempo de execução via `NotificationContext`.

### 3. Facade
- **Java Puro**: Classe `Facade` unificando a subsistência de CRM (`CrmService`) e consulta de CEP (`CepApi`).
- **Spring Framework**: `ClienteServiceImpl` atuando como Fachada para abstrair a persistência H2 via Spring Data JPA, a integração HTTP externa via Feign Client (`ViaCepService`) e os disparos de notificação via `NotificationStrategy`.

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- JDK 21 instalado e configurado nas variáveis de ambiente.

### Passos
1. Clone este repositório:
   ```bash
   git clone <URL_DO_SEU_REPOSITORIO>
   cd dio-design-patterns
   ```

2. Compile o projeto:
   ```bash
   mvn clean package
   ```

3. Execute a aplicação Spring Boot:
   ```bash
   mvn spring-boot:run
   ```

4. Acesse a documentação interativa Swagger UI no seu navegador:
   ```text
   http://localhost:8080/swagger-ui.html
   ```

5. Acesse o console do banco de dados H2 (opcional):
   ```text
   http://localhost:8080/h2-console
   JDBC URL: jdbc:h2:mem:dio_db
   User: sa
   Password: (deixar em branco)
   ```

---

## 📌 Endpoints Principais

### API REST de Clientes (`/clientes`)
- `GET /clientes`: Lista todos os clientes cadastrados.
- `GET /clientes/{id}`: Busca um cliente por ID.
- `POST /clientes`: Cadastra um cliente consultando o CEP automaticamente no ViaCEP.
- `POST /clientes/com-notificacao?tipoNotificacao=EMAIL`: Cadastra um cliente e dispara notificação via Strategy (EMAIL, SMS ou WHATSAPP).
- `PUT /clientes/{id}`: Atualiza os dados de um cliente.
- `DELETE /clientes/{id}`: Remove um cliente.

### Testes dos Padrões GoF Puros (`/gof-test`)
- `GET /gof-test/singleton`: Testa a garantia de instância única dos Singletons GoF.
- `GET /gof-test/strategy`: Executa a troca de comportamentos do Robô.
- `GET /gof-test/facade`: Executa a migração simplificada via Facade.

---

## 📤 Como Entregar na DIO

1. Crie um repositório no seu GitHub.
2. Adicione este código ao seu repositório:
   ```bash
   git init
   git add .
   git commit -m "feat: projeto final padroes de projeto java e spring"
   git branch -M main
   git remote add origin https://github.com/SEU_USUARIO/dio-design-patterns.git
   git push -u origin main
   ```
3. Copie a URL do seu repositório e cole no campo de entrega da plataforma DIO!
