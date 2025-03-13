package com.example.apigateway.controller;

import com.example.gameengineservice.api.GameAPI;
import com.example.gameengineservice.dto.GameResponse;
import com.example.gameengineservice.dto.MoveRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/session", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GameController {

    GameAPI gameAPI;

    @PostMapping({"/create"})
    public GameResponse createGame() {
        return gameAPI.createGame();
    }

    @PostMapping({"/{gameId}/move"})
    public GameResponse makeMove(@PathVariable UUID gameId, @RequestBody @Valid MoveRequest move) {
        return gameAPI.makeMove(gameId, move);
    }

    @GetMapping({"/{gameId}"})
    public GameResponse getGameState(@PathVariable @NotNull UUID gameId) {
        return gameAPI.getGameState(gameId);
    }
}
