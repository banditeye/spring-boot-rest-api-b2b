# Spring boot REST api for b2b

#Example project exist on http://92.222.84.152:4200
#Swagger documentation exist on http://92.222.84.152:8080/b2b-0.1.0/swagger-ui.html


API documentation.

```
mvn spring-boot:run
open http://localhost:8080/swagger-ui.html
```


## Docker Support

Dev

```bash
mvn clean package -DskipTests=true -Dmaven.javadoc.skip=true
docker build -t IMAGE .
docker run -p 8080:8080 IMAGE
```

Prod

```bash
mvn clean package -DskipTests=true -Dmaven.javadoc.skip=true
docker build --build-arg JASYPT_ENCRYPTOR_PASSWORD=secret -t IMAGE .
docker run -p 8080:8080 \
  -e "SPRING_PROFILES_ACTIVE=prod" \
  -e "MYSQL_ENDPOINT=dbhost:3306" \
  -e "NEW_RELIC_LICENSE_KEY=newrelic licence key" \
  IMAGE
```




## License

[MIT](/LICENSE)


