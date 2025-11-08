package com.olehprukhnytskyi.macrotrackergoalservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Calculated nutrition goals response")
public class GoalResponseDto {
    @Schema(description = "Daily calorie target", example = "2250")
    private int calories;

    @Schema(description = "Daily protein target in grams", example = "140")
    private int protein;

    @Schema(description = "Daily fat target in grams", example = "62")
    private int fat;

    @Schema(description = "Daily carbohydrates target in grams", example = "281")
    private int carbohydrates;
}
