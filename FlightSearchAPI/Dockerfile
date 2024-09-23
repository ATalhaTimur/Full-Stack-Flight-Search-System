FROM openjdk:22-jdk-slim
LABEL authors="talhatimur"

WORKDIR /app

COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]