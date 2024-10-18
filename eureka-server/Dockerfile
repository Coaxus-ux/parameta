FROM gradle:7.5.1-jdk17 AS build

WORKDIR /app

COPY . /app

RUN gradle build --no-daemon -x test
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/build/libs/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
