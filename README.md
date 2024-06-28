Olá!!

Esse projeto foi desenvolvido em duas partes:
1. Funcionalidades ligadas a inversão de itens de um ArrayList ou List,
1.2 Retorno de valores de um csv em uma Lista de String
2. Endpoints relacionados a família, parents e children

Caso queira testar os endpoints relacionados à família, basta acessar as URL's:
1. Clone o projeto
2. Rode o comando 'mvn clean install'
3. Rode o microsserviço, por sua IDE de preferência, ou pelo comando 'mvn spring-boot:run'
4. Acessar as seguintes URL's, ou testar as funcionalidades rodando os testes unitários

a. A list of all FATHER names <br>
  http://localhost:8080/parent/father <br>
b. All FATHER names that have mor than one child <br>
  http://localhost:8080/parent/father/many-children <br>
c. For every CHILD, the name of his/her father and mother, if defined <br>
  http://localhost:8080/family/names <br>
d. How many children John has <br>
  http://localhost:8080/parent/father/John <br>
e. How many children Mary has <br>
  http://localhost:8080/parent/mother/Mary <br>
  
