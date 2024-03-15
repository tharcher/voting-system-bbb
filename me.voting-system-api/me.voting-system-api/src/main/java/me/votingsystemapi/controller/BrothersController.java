package me.votingsystemapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import me.votingsystemapi.config.BrothersConfig;
import me.votingsystemapi.config.ReferencesConfig;
import me.votingsystemapi.model.BrothersModel;
import me.votingsystemapi.model.ReferencesModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/brothers")

public class BrothersController {
    private final BrothersConfig config;

    public BrothersController(BrothersConfig config) {
        this.config = config;
    }

    @PostMapping("/save")
    @Operation(summary = "teste")
    public ResponseEntity<BrothersModel> save(@RequestBody BrothersModel brother) {
        BrothersModel entity = config.save(brother);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/search")
    @Operation(summary = "teste")
    public ResponseEntity<BrothersModel> search(@RequestParam String id) {
        Optional<BrothersModel> optBrothers = config.findById(id);

        return optBrothers.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping("/search/all")
    @Operation(summary = "teste")
    public ResponseEntity<List<BrothersModel>> searchAll() {
        Optional<List<BrothersModel>> optBrothers;
        optBrothers = Optional.of(config.findAll());

        return optBrothers.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }
}
