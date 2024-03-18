FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
#FROM openjdk:11
#ADD target/user-api*.jar user-api.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "user-api.jar"]