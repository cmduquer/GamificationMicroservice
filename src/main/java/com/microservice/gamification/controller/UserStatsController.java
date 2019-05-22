package com.microservice.gamification.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.gamification.domain.GameStats;
import com.microservice.gamification.service.GameService;

import lombok.extern.slf4j.Slf4j;

/**
 * This class implements a REST API for the Gamification User Statistics service.
 */
@RestController
@Slf4j
@RequestMapping("/stats")
class UserStatsController {

    private final GameService gameService;

    public UserStatsController(final GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public GameStats getStatsForUser(@RequestParam("userId") final Long userId) {
    	log.info("User id @ {}", userId);
        return gameService.retrieveStatsForUser(userId);
    }
}