# movie-backend-sda

Este projeto tem como objetivo implementar um sistema utilizando as tecnologias: Spring Boot, Spring Data JPA, Spring Security e Maven.

Com isso, o sistema ira disponibilizar um serviço REST com o objeto de gerênciar um sistema para filmes.

## Criação do Banco de Dados ##

No seu MySQL local, é necessário a criação de uma base vazia chamada `movie-sda-bd`, usando seguinte comando:

```sql

CREATE DATABASE movie-sda-bd WITH ENCODING='UTF8';

```


## Configuração dos dados do banco na aplicação##

Para rodar localmente, alterar as seguintes configurações no arquivo "aplication.properties" da aplicação de acordo os dados do seu banco MySQL:
```code

spring.datasource.url = jdbc:mysql://localhost:3306/movie-sda-bd
spring.datasource.username = [seu_usuario_do_banco]
spring.datasource.password = [sua_senha_do_banco]
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```

Feito isso, basta partir para os próximo passos.


## Configuração do JAVA ##

O projeto utiliza o jdk 1.8, então, o mesmo precisa ser instalado.

## Configuração do Ambiente de Desenvolvimento ##

**IDE:** Eclipse JAVA EE Neon Release (4.6.0).

**Banco de dados**: MySQL Workbench 6.3 Community.

**Teste serviços REST**: Postman 4.2.1.

**Sistema Operacional**: Windows 7 x64.

OBS: O sistema operacional não restringe a sua utilização em outros SO's.

## Configuração do Projeto na IDE ##

O projeto é do tipo Maven, então basta importá-lo como tal.



## Coleções Postman ##

Abaixo segue os link's das coleções utilizadas no Postman para testar os serviços REST.
Para instalar a extensão do Postman no Google Chrome [click aqui](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop)

