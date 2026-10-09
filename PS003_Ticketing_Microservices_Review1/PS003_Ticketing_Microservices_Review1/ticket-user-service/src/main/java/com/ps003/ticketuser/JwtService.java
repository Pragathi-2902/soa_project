package com.ps003.ticketuser;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    // Must be the same secret used by API Gateway.
    private static final String SECRET =
        "PS003-Review1-JWT-Secret-Key-For-Demo-2026-ChangeThisLater-1234567890";

    private final SecretKey key =
        Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String username) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + 60 * 60 * 1000);

        return Jwts.builder()
                .subject(username)
                .issuedAt(now)
                .expiration(expiry)
                .signWith(key)
                .compact();
    }
}
