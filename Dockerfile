FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-alpine
COPY --from=build /target/macro-tracker-goal-service-0.0.1-SNAPSHOT.jar macro-tracker-goal-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "macro-tracker-goal-service.jar"]
