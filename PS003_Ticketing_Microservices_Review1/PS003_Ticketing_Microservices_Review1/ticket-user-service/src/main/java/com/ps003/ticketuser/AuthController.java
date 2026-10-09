package com.ps003.ticketuser;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody LoginRequest request) {
        return Map.of(
            "message", "Registration successful for " + request.username(),
            "note", "Review-1 demo uses in-memory users."
        );
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {

        if (("neha".equals(request.username()) && "1234".equals(request.password()))
                || ("priya".equals(request.username()) && "2468".equals(request.password()))
                || ("rahul".equals(request.username()) && "5678".equals(request.password()))
                || ("ananya".equals(request.username()) && "1357".equals(request.password()))
                || ("arjun".equals(request.username()) && "7890".equals(request.password()))
                || ("sneha".equals(request.username()) && "4321".equals(request.password()))
                || ("kiran".equals(request.username()) && "1234".equals(request.password()))) {

            return Map.of(
                "username", request.username(),
                "token", jwtService.generateToken(request.username())
            );
        }

        throw new UnauthorizedException("Invalid username or password");
    }

    public record LoginRequest(String username, String password) {}

    @ResponseStatus(org.springframework.http.HttpStatus.UNAUTHORIZED)
    static class UnauthorizedException extends RuntimeException {

        public UnauthorizedException(String message) {
            super(message);
        }
    }
}