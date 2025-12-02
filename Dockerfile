FROM olehprukhnytskyi/base-java-otel:21
WORKDIR /app
COPY target/macro-tracker-goal-service-0.0.1-SNAPSHOT.jar macro-tracker-goal-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "macro-tracker-goal-service.jar"]