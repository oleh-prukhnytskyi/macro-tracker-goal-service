package com.olehprukhnytskyi.macrotrackergoalservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GoalResponseDto {
    private int calories;
    private int protein;
    private int fat;
    private int carbohydrates;
}
