package me.votingsystemapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;


@RestController
public class StatusController {

    @GetMapping("/api/status")
    @Operation(summary = "Retorna o status da aplicação")
   public ResponseEntity<String> status() {
       return  ResponseEntity.ok("online");
   }

}
