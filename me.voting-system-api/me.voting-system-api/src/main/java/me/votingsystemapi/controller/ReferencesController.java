package me.votingsystemapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import me.votingsystemapi.config.ReferencesConfig;
import me.votingsystemapi.model.ReferencesModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@RestController
@RequestMapping("/api/references")

public class ReferencesController {
    private final ReferencesConfig config;

    public ReferencesController(ReferencesConfig config) {
        this.config = config;
    }

    @PostMapping("/save")
    @Operation(summary = "teste")
    public ResponseEntity<ReferencesModel> save(@RequestBody ReferencesModel reference) {
        ReferencesModel entity = config.save(reference);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/search")
    @Operation(summary = "teste")
    public ResponseEntity<ReferencesModel> search(@RequestParam String key) {
        Optional<ReferencesModel> optReference = config.findById(key);

        return optReference.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }
}
