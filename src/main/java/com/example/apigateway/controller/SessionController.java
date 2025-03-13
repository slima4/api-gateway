package com.example.apigateway.controller;

import com.example.gamesessionservice.api.SessionAPI;
import com.example.gamesessionservice.dto.CreateSessionResponse;
import com.example.gamesessionservice.dto.SessionResponse;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/session", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SessionController {

    SessionAPI sessionAPI;

    @PostMapping
    public CreateSessionResponse createSession() {
        return sessionAPI.createSession();
    }

    @PostMapping({"/{sessionId}/simulate"})
    public void simulateGame(@PathVariable UUID sessionId) {
        sessionAPI.simulateGame(sessionId);
    }

    @GetMapping({"/{sessionId}"})
    public SessionResponse getSession(@PathVariable UUID sessionId) {
        return sessionAPI.getSession(sessionId);
    }
}
