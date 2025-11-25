FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY target/macro-tracker-goal-service-0.0.1-SNAPSHOT.jar macro-tracker-goal-service.jar
COPY opentelemetry-javaagent.jar /opt/opentelemetry/opentelemetry-javaagent.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "macro-tracker-goal-service.jar"]