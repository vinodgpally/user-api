# Read Me First
The following are steps as part of building this user-api project:

### Tools required

* JDK 11
* Maven
* Docker

### Execution Steps

1. Run mvn command at pom.xml directory level ```mvn clean install -DskipTests```
2. Make sure docker service is running on the machine and then run ```docker-compose up --build```
3. To run the unit tests use ```mvn test```

