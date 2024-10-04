package org.oril.controllers;

import lombok.AllArgsConstructor;
import org.oril.entities.AuthRequest;
import org.oril.entities.AuthResponse;
import org.oril.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {
        System.out.println("request -> "+request.toString());
        return ResponseEntity.ok(authService.register(request));
    }
}
