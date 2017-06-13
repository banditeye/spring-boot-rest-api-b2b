# Spring boot REST api for b2b

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


