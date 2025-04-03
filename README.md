# Projeto de Orçamentos com Java Spring Boot e PostgreSQL

## 📌 Sobre o Projeto

Este é um projeto autoral desenvolvido para a experimentação e aplicação dos conhecimentos adquiridos durante os estudos de **Java**, **Spring Boot** e **PostgreSQL**. O sistema implementa CRUDs para cadastros, cálculos de precificação, regras de negócio, além de testes unitários e de integração, garantindo a qualidade do código e a confiabilidade do sistema.

O projeto visa unir minha experiência profissional na área de **orçamentos de obras e comunicação visual** com o aprendizado em **desenvolvimento backend**, proporcionando um ambiente prático para aprimorar e expandir minhas habilidades em programação.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot** (Spring Web, Spring Data JPA, Spring Security)
- **PostgreSQL**
- **Flyway** (Migrations)
- **JUnit** & **Mockito** (Testes)
- **Lombok** (Facilitador de código) 
- **Swagger** (Documentação da API)
- **JWT** (Autenticação segura - em desenvolvimento)

---

## 🔧 Funcionalidades

✅ Cadastro e gerenciamento de insumos, fornecedores e clientes  
✅ CRUD completo com validações e regras de negócio  
✅ Cálculo de precificação baseado em composições unitárias  
✅ Registro de histórico de preços  
✅ Autenticação e autorização com JWT  
✅ Testes unitários e de integração  
✅ API documentada com Swagger  

---

## ⚙️ Como Executar o Projeto

### 🔹 Pré-requisitos
Antes de começar, você precisará ter instalado na sua máquina:
- **JDK 21+**
- **PostgreSQL**

### 🔹 Rodando o Projeto
1. Clone este repositório:
   ```bash
   git clone https://github.com/GeciaraBoava/sistema_orcamento.git
   ```

2. Acesse a pasta do projeto:
   ```bash
   cd sistema-orcamento
   ```

3. Configure o **application.properties** com as credenciais do PostgreSQL:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```

4. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

---

## 🔍 Testes
Para executar os testes automatizados:
```bash
mvn test
```

---

## 📜 Roadmap Futuro
🔹 Implementação de **Docker** para facilitar o ambiente de desenvolvimento 
🔹 Deploy da aplicação 
🔹 Melhorias na estrutura do banco de dados 
🔹 Refatoração de código para seguir boas práticas (SOLID, Clean Code) 

---

## 🤝 Contribuição
Este é um projeto autoral, mas sugestões são sempre bem-vindas! Caso tenha alguma ideia ou encontre melhorias, fique à vontade para abrir uma **issue** ou enviar um **pull request**. 😊

---

## 📄 Licença
Este projeto está sob a licença MIT - sinta-se livre para utilizá-lo e modificá-lo conforme necessário.

---

## 📞 Contato
Caso tenha dúvidas ou queira trocar ideias, me encontre no LinkedIn:
[![LinkedIn](https://img.shields.io/badge/LinkedIn-000?style=for-the-badge&logo=linkedin&logoColor=0A66C2)](https://www.linkedin.com/in/geciaraboava/)
