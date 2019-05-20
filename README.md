# NOTE MANAGEMENT

### Reference Documentation
Simple RESTfull microservice implemented with Spring Boot 2 and PostgreSQL.
With this service you can add , modify, remove and get notes.

### Additional Information
You can up application by running command 
```$xslt
docker-compose up
```
You just need to be sure that before it 
```$xslt
./gradlew build
```
command was successfully run.

##Here are endpoints for creating, modifing and getting notes

Create NOTE:
```$xslt
 Method: POST http://localhost:8080/notes
```

Modify NOTE:
```$xslt
 Method: PUT http://localhost:8080/notes
```

GET NOTE:
```$xslt
 Method: GET http://localhost:8080/notes/{id}
```

GET ALL NOTES:
```$xslt
 Method: GET http://localhost:8080/notes/
```

Please, be sure that your headers are contains
```$xslt
Content-Type: application/json;charset=UTF-8 Accept: application/json;charset=UTF-8
```
