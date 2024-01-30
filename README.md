# ⭐ Pós Tech (Fase 2) - **Gestão de Estacionamentos**

---

### Descrição:


O projeto "Gestão de Estacionamentos" surge com o objetivo de aprimorar o sistema de parquímetro atualmente em uso, conforme especificado no Tech Challenge, com a finalidade de proporcionar uma experiência mais confiável. A nova solução para parquímetros, desenvolvida pela nossa equipe, mantém as regras de negócio existentes, ao mesmo tempo em que incorpora uma abordagem tecnológica inovadora.

Ao adotar as mais recentes tecnologias do mercado, nosso sistema se destaca pela sua ênfase na otimização das operações de gravação e leitura de dados. Utilizando APIs modernas e um banco de dados NoSQL, a solução oferece melhorias significativas na eficiência operacional. Essa abordagem não apenas aprimora o desempenho atual do sistema, mas também contribui para a escalabilidade iminente, garantindo que o sistema possa crescer de maneira eficaz para atender às demandas futuras. 

## 💥 Como executar o projeto?

1. Instalar as dependências do do projeto através do maven.
2. Utiliza banco de dados NoSql MongoDB com suas definições no arquivos de propriedades do Spring.
3. Utiliza sistema de autenticação e autorização baseado em tokens JWT (Spring Security). 
4. Context-path: **/parking-management/api**.
5. Executar a aplicação através da classe **CommunityManagementApplication.java**.


## 🚀 Tecnologias Utilizadas

- **Spring Boot:** versão 3.2.1
- **Spring Security:** versão 3.2.1
- **Java:** versão 17
- **MongoDB Atlas**
- **Springdoc-openapi-Swagger** versão 2.3.0


## 🔒 APIs Externas Utilizadas 

- [Via CEP](https://viacep.com.br/)
- [Brasil API](https://brasilapi.com.br/)
- Base de dados de vagas zona azul na cidade de São Paulo

## 🛠️ Ferramentas Utilizadas 

- [GitHub](https://github.com/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Postman](https://www.postman.com/)
- [Draw.io](https://app.diagrams.net/)
- [MongoDB Atlas](https://www.mongodb.com/cloud/atlas)


### 📋 Swagger 

- http://localhost:8080/parking-management/api/swagger-ui/index.html#/

⚠️ É essencial adquirir o Bearer Token por meio da etapa prévia de autenticação, realizando o login através da rota (/signin). Utilize a rota (/user) para efetuar o cadastro do seu usuário. 


## 😎 Collection para testes
[Fiap - Parking Management.postman_collection](https://github.com/brunolimadev/parking-management/blob/c0e274dd3e4a804d6b9acc06b44e483ab12dad14/src/test/resources/Parking-management.postman_collection.zip?raw=true)
