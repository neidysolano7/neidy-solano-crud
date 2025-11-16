# Etapa 1: construir el JAR con Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn -q -DskipTests package

# Etapa 2: imagen ligera para ejecutar
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/target/neidy-solano-crud-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
