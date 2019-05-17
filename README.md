# spingboot-udev
spingboot-udev

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
