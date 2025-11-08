package com.olehprukhnytskyi.macrotrackergoalservice.controller;

import com.olehprukhnytskyi.macrotrackergoalservice.dto.GoalResponseDto;
import com.olehprukhnytskyi.macrotrackergoalservice.dto.UserDetailsRequestDto;
import com.olehprukhnytskyi.macrotrackergoalservice.service.CalorieCalculatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/goals")
@Tag(
        name = "Goal Calculation API",
        description = "Calculate nutrition goals based on user profile and fitness objectives"
)
public class GoalController {
    @Operation(
            summary = "Calculate nutrition goals",
            description = "Uses Mifflin-St Jeor formula with activity level multiplier, "
                    + "then adjusted to fitness goal."
    )
    @PostMapping
    public ResponseEntity<GoalResponseDto> calculateGoal(
            @RequestBody @Valid UserDetailsRequestDto requestDto) {
        return ResponseEntity.ok(CalorieCalculatorService.calculateGoal(requestDto));
    }
}
