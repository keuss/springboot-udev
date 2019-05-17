# spingboot-udev
spingboot-udev

3 controller REST see : com.example.demo.controller

`git clone https://github.com/keuss/spingboot-udev.git`

## Buid

 - `mvn clean install`
 
## Run

 - `java -jar target\demo-0.0.1-SNAPSHOT.jar`
 
## Test

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
