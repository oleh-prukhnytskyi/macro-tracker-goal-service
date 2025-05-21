package com.olehprukhnytskyi.macrotrackergoalservice.service;

import com.olehprukhnytskyi.macrotrackergoalservice.dto.GoalResponseDto;
import com.olehprukhnytskyi.macrotrackergoalservice.dto.UserDetailsRequestDto;
import com.olehprukhnytskyi.macrotrackergoalservice.util.ActivityLevel;
import com.olehprukhnytskyi.macrotrackergoalservice.util.Gender;
import com.olehprukhnytskyi.macrotrackergoalservice.util.Goal;

public class CalorieCalculatorService {
    public static GoalResponseDto calculateGoal(UserDetailsRequestDto goal) {
        int calories = calculateCalories(goal);

        int protein = 0;
        if (goal.getGoal() == Goal.LOSE) {
            protein = (int) (goal.getWeight() * 1.8);
        } else if (goal.getGoal() == Goal.MAINTAIN) {
            protein = (int) (goal.getWeight() * 1.5);
        } else if (goal.getGoal() == Goal.GAIN) {
            protein = (int) (goal.getWeight() * 1.6);
        }
        int fat = goal.getWeight();
        int carbs = (calories - (protein * 4 + fat * 4)) / 4;

        return new GoalResponseDto(calories, protein, fat, carbs);
    }

    private static int calculateCalories(UserDetailsRequestDto goal) {
        double calories = 10 * goal.getWeight()
                + 6.25 * goal.getHeight()
                - 5 * goal.getAge();

        if (goal.getGender() == Gender.MALE) {
            calories += 5;
        } else if (goal.getGender() == Gender.FEMALE) {
            calories -= 161;
        }

        ActivityLevel activity = goal.getActivityLevel();
        if (activity == ActivityLevel.SEDENTARY) {
            calories *= 1.2;
        } else if (activity == ActivityLevel.LIGHTLY_ACTIVE) {
            calories *= 1.375;
        } else if (activity == ActivityLevel.MODERATELY_ACTIVE) {
            calories *= 1.550;
        } else if (activity == ActivityLevel.VERY_ACTIVE) {
            calories *= 1.725;
        } else if (activity == ActivityLevel.EXTRA_ACTIVE) {
            calories *= 1.9;
        }

        Goal goalType = goal.getGoal();
        if (goalType == Goal.LOSE) {
            calories *= 0.85;
        } else if (goalType == Goal.GAIN) {
            calories += 500;
        }

        return (int) calories;
    }
}
