package com.olehprukhnytskyi.macrotrackergoalservice.dto;

import com.olehprukhnytskyi.macrotrackergoalservice.util.ActivityLevel;
import com.olehprukhnytskyi.macrotrackergoalservice.util.Gender;
import com.olehprukhnytskyi.macrotrackergoalservice.util.Goal;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UserDetailsRequestDto {
    @NotNull
    @Positive
    private int age;

    @NotNull
    @Positive
    private int weight;

    @NotNull
    @Positive
    private int height;

    @NotNull
    private Goal goal;

    @NotNull
    private Gender gender;

    @NotNull
    private ActivityLevel activityLevel;
}
