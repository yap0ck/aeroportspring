## utiliser l'image de java
#FROM openjdk:17
#
## set rpertoire de travail du docker
#WORKDIR /app
#
## copier le .jar dans le conteneur
#COPY target/aeroportSpring-0.0.1-SNAPSHOT.jar app/aeroportSpring-0.0.1.jar
#
## exposer le port
#EXPOSE 8080
#
##executer
#CMD["java",".jar","aeroportSpring-0.0.1.jar"]

FROM maven:3.6.3-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install -DskipTests

FROM openjdk:17
ARG JAR_FILE=/app/target/*.jar
COPY --from=builder ${JAR_FILE} aeroport.jar
ENTRYPOINT ["java", ".jar", "/aeroport.jar"]