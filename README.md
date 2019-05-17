# spingboot-udev

spingboot 2 example BOOK API projet

 - 3 REST controllers, see : package `com.example.demo.controller`
 - BookController use service with H2 mem DB see `application.properties` file

`git clone https://github.com/keuss/spingboot-udev.git`

## Buid

 - `mvn clean install`
 
## Run

 - `java -jar target\demo-0.0.1-SNAPSHOT.jar`
 
## Test

Use Postman to test the REST services ... must add somme books first ;-)

POST http://localhost:8080/api/books
```
{
	"title": "LOTR 1",
	"author": "toto"
}
```

GET http://localhost:8080/api/books/

GET http://localhost:8080/api/books/1

GET http://localhost:8080/api/books/author/toto
