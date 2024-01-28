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


## 🚀 Como testar?

1. /vehicles
2. /users
3. /checkin
4. /users
5. /payment
6. /signin
7. /zones

### Serviços REST

Veja abaixo o modelo dos payloads ou caso prefira, execute o projeto e acesse o link abaixo para ver o swagger:
http://localhost:8080/parking-management/api/swagger-ui/index.html#/

⚠️ É essencial adquirir o Bearer Token por meio da etapa prévia de autenticação, realizando o login através da rota (/signin). Utilize a rota (/user) para efetuar o cadastro do seu usuário. 

[GET] */vehicles* - Resposta

```json
{
  "vehicles": [
    {
      "name": "string",
      "model": "string",
      "type": "CAR",
      "plate": "string"
    }
  ]
}
```

[PUT] */vehicles* - Requisição


```json
{
  "name": "string",
  "model": "string",
  "type": "CAR",
  "plate": "string",
  "createdAt": "2024-01-28T03:30:28.524Z",
  "updatedAt": "2024-01-28T03:30:28.524Z"
}
```
[PUT] */vehicles* - Resposta

```json
{
  "name": "string",
  "model": "string",
  "type": "CAR",
  "plate": "string"
}
```

[POST] */vehicles* - Requisição

```json
{
  "name": "string",
  "model": "string",
  "type": "CAR",
  "plate": "string",
  "createdAt": "2024-01-28T03:44:46.702Z",
  "updatedAt": "2024-01-28T03:44:46.702Z"
}
``` 

[POST] */vehicles* - Resposta

```json
{
  "name": "string",
  "model": "string",
  "type": "CAR",
  "plate": "string"
}
``` 
[GET] */vehicles/{id}* - Resposta

```json
{
  "name": "string",
  "model": "string",
  "type": "CAR",
  "plate": "string"
}
```
[DELETE] */vehicles/{id}* - Resposta

```json
{}
```

[POST] */users* - Requisição

```json
{
  "name": "string",
  "email": "string",
  "password": "';A3DK\"!8?n}",
  "createdAt": "2024-01-28T03:52:45.071Z",
  "role": "ROLE_ADMIN"
}
```
[POST] */users* - Resposta

```json
{}
```

[POST] */payment* - Requisição

```json
{
  "type": "string",
  "card": {
    "type": "string",
    "number": "1727-1580-3469-2160",
    "expiringDate": "02/24",
    "verificationCode": "722"
  },
  "amount": 10.0
}
```
[POST] */payment* - Resposta

```json
{
  "Forma de Pagamento": "string",
  "Número do Cartão": "1727-xxxx-xxxx-2160",
  "Valor Pago": 10.0,
  "status": {
    "Pagamento aprovado:": true,
    "Mensagem": "string"
  }
}
```

[POST] */checkin* - Requisição

```json
{
  "period": "string",
  "address": {
    "id": "string",
    "local": "string"
  },
  "vehicle": {
    "name": "string",
    "model": "string",
    "type": "CAR",
    "plate": "string",
    "createdAt": "2024-01-28T04:04:12.267Z",
    "updatedAt": "2024-01-28T04:04:12.267Z"
  },
  "payment": {
    "type": "string",
    "card": {
      "type": "string",
      "number": "5183-4283-1981-6491",
      "expiringDate": "38/29",
      "verificationCode": "624"
    },
    "amount": 0
  }
}
```
[POST] */checkin* - Resposta

```json
{
  "period": "string",
  "address": {
    "id": "string",
    "local": "string"
  },
  "vehicle": {
    "name": "string",
    "model": "string",
    "type": "CAR",
    "plate": "string"
  },
  "payment": {
    "type": "string",
    "card": {
      "type": "string",
      "number": "6277-5024-7216-4553",
      "expiringDate": "70/03",
      "verificationCode": "470"
    },
    "amount": 0
  }
}
```
[POST] */auth/signin* - Requisição

```json
{
  "email": "string",
  "password": "string"
}
```
[POST] */auth/signin* - Resposta

```json
{
  "isAuthenticated": true,
  "name": "String"
}
```

[GET] */zones* - Requisição

```json
{
  "page": 0,
  "size": 1,
  "sort": [
    "string"
  ]
}
```
[GET] */zones* - Resposta

```json
{
  "totalPages": 0,
  "totalElements": 0,
  "size": 0,
  "content": [
    {
      "id": "string",
      "local": "string"
    }
  ],
  "number": 0,
  "sort": {
    "empty": true,
    "unsorted": true,
    "sorted": true
  },
  "pageable": {
    "offset": 0,
    "sort": {
      "empty": true,
      "unsorted": true,
      "sorted": true
    },
    "paged": true,
    "unpaged": true,
    "pageNumber": 0,
    "pageSize": 0
  },
  "numberOfElements": 0,
  "first": true,
  "last": true,
  "empty": true
}
```
[GET] */zones/local* - Requisição

### Parâmetros
- **filterByCep:** Numeração do Cep.
- **filterByLocal:** Localidade do endereço.

[GET] */zones/local* - Resposta

```json
[
  {
    "id": "string",
    "local": "string"
  }
]
```
## 😎 Collection para testes
[fiap-community-manager.postman_collection.json]([Fiap - Parking Management.postman_collection.json](https://github.com/brunolimadev/parking-management/src/test/resources/Fiap%20-%20Parking%20Management.postman_collection.json)
