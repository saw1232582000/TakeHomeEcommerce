package com.Ecommerce.Ecommerce.application.Service;

import com.Ecommerce.Ecommerce.domain.modal.User.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {
    private final String SECRET_KEY="4bb6d1dfbafb64a681139d1586b6f1160d18159afd57c8c79136d7490630407c";

    public String extractUsername(String token){
        return extractClaim(token,Claims::getSubject);
    }
    public String extractUserId(String token){
        return extractClaim(token,claims -> claims.get("userId",String.class));
    }

    public boolean isValid(String token, UserDetails user){
        String userName = extractUsername(token);
        return userName.equals(user.getUsername()); //TODO: check token expiration here
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims,T> resolver){
        Claims claims= extractAllClaims(token);
        return resolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts
                .parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String generateToken(User user){
        return Jwts
                .builder()
                .subject(user.getUsername())
                .claim("userId", user.getId())
                .issuedAt(new Date(System.currentTimeMillis()))
                .signWith(getSigningKey())
               // .expiration(new Date())  TODO: set expiration date for token here
                .compact();


    }

    public SecretKey getSigningKey(){
        byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);

    }
}
