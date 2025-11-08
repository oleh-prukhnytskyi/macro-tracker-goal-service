package com.olehprukhnytskyi.macrotrackergoalservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Goal Service API",
                version = "1.0",
                description = "Microservice for calculating user nutrition "
                        + "goals based on profile data"
        )
)
@SpringBootApplication
public class MacroTrackerGoalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MacroTrackerGoalServiceApplication.class, args);
    }

}
