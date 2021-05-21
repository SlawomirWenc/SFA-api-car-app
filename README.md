# SFA-api-car-app
Simple factor authorization API car application

Application api contains data about fifty cars.
Not logged user can only get data about all cars.
More detailed request required registration and confirm by email.

There is a created user for testing with an active account and information about his email and password are in main page application.

*To register the user and confirm via e-mail, it is necessary to modify the value in file application.properties: spring.mail.username and spring.mail.password.

### Technologies:
* Java 11
* Spring Boot 2.5.0
* Spring Web
* Spring Data JPA
* H2
* Spring Security
* Java Mail Sender
* Thymeleaf
* Bootstrap 4

### Screenshots:
#### Main page
![main](https://user-images.githubusercontent.com/62851137/119176315-3c3f9900-ba6b-11eb-916e-6e7b92b5e050.png)
#### Sing In page
![singin](https://user-images.githubusercontent.com/62851137/119176756-c2f47600-ba6b-11eb-97d3-ddf073ef7dfa.png)
#### Swagger UI
![swaggerui](https://user-images.githubusercontent.com/62851137/119176817-d30c5580-ba6b-11eb-8cc4-0590cfba9e09.png)
#### Data from api/cars/all 
![app-data](https://user-images.githubusercontent.com/62851137/119176177-0e5a5480-ba6b-11eb-840c-bd98ed17e990.png)
