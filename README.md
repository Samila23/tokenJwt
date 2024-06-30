## Token JWT
### Resumo Geral do projeto:

Esta API Rest é responsável por validar token JWT.

### Getting Started

* Java 11
* Maven
* SpringBoot
* Junit

## Regras a ser validadas pela API.

* Deve ser um JWT válido
* Deve conter apenas 3 claims(Name, Role e Seed)
* A claim Name não pode ter carácter de números
* A claim Role deve conter apenas 1 dos três valores (Admin, Member e External)
* A claim Seed deve ser um número primo.
* O tamanho máximo da claim Name é de 256 caracteres. 



## Criação de massas para testes

Indico usar a site (https://jwt.io/), nele é possível gerar tokens e manipular cenários conforme regras acima.
Requisito: Serviço está validar a chave de segurança do token, para isso gerar token com a senha "Admin"

Abaixo um exemplo:
 ![image](https://github.com/Samila23/tokenJwt/assets/60451467/d43f3e06-613e-4665-a1fd-00b012e30851)



### Building

Após subida do projeto,realizar teste na plataforma de sua preferência.
Ex: Postam
url: http://localhost:8080/token
Após gerar o token conforme passo anterior, esse serviço espera recebe-lo no header o token gerado no passo anterior.

Abaixo um exemplo:
![image](https://github.com/Samila23/tokenJwt/assets/60451467/1872a8a5-5717-40fd-96da-0d52200cd590)

