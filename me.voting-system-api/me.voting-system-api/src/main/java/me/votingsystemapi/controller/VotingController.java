package me.votingsystemapi.controller;

import lombok.AllArgsConstructor;
import me.votingsystemapi.config.service.VotingService;
import me.votingsystemapi.model.BrothersModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/voting")
@AllArgsConstructor
public class VotingController {
    private final VotingService service;

    @PostMapping
    public ResponseEntity<String> vote(@RequestBody BrothersModel brother) {
        service.addEvent(brother);
        return ResponseEntity.ok("vote validated");

    }
}
