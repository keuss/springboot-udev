# spingboot-udev

spingboot 2 example BOOK API projet (list books, add books, find by author, ...)

 - Build and run with open jdk 11 (https://openjdk.java.net/) min jdk 8, see <java.version> maven propertie
 - 3 REST controllers, see : package `com.example.demo.controller`
 - BookController use service, spring data with H2 mem DB (see `application.properties` file)

Get project : `git clone https://github.com/keuss/spingboot-udev.git`

## Buid

 - `mvn clean install`
 
## Run

 - `java -jar target\demo-0.0.1-SNAPSHOT.jar`
 
## Test

Use for instance Postman to test the REST services https://www.getpostman.com/downloads/ ... must add somme books first ;-)

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
