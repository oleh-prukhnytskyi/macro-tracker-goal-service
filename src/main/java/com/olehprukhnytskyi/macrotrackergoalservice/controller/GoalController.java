package com.olehprukhnytskyi.macrotrackergoalservice.controller;

import com.olehprukhnytskyi.macrotrackergoalservice.dto.GoalResponseDto;
import com.olehprukhnytskyi.macrotrackergoalservice.dto.UserDetailsRequestDto;
import com.olehprukhnytskyi.macrotrackergoalservice.service.CalorieCalculatorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/goals")
public class GoalController {
    @PostMapping
    public ResponseEntity<GoalResponseDto> calculateGoal(
            @RequestBody @Valid UserDetailsRequestDto requestDto) {
        return ResponseEntity.ok(CalorieCalculatorService.calculateGoal(requestDto));
    }
}
