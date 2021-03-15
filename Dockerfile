FROM maven:3.6.3-jdk-11 AS build

WORKDIR /app
COPY src src/
COPY pom.xml .

RUN mvn clean package

FROM adoptopenjdk/openjdk11:alpine-jre
ENV LANG=en_US.UTF-8

EXPOSE 8080

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]