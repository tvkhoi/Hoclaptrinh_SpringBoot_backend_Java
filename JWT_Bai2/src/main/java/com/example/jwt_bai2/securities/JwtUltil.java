package com.example.jwt_bai2.securities;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUltil {
    @Value( "${jwt.secret}")
    private String secret;

    @Value( "${jwt.expirationMs}")
    private  int expirationMs;

    // Tạo ra token từ username
    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new java.util.Date(System.currentTimeMillis() + expirationMs))
                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, secret)
                .compact();
    }
    // Lấy ra username từ token
    public String getUsernameFromJwtToken(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    // Kiểm tra xem token hợp lệ không
    public boolean validateJwtToken(String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch(SignatureException signatureException){
            System.err.println("Invalid JWT signature: "+ signatureException.getMessage());
        }
        catch (ExpiredJwtException expiredJwtException){
            System.err.println("Expired JWT token: "+ expiredJwtException.getMessage());
        }
        catch (UnsupportedJwtException e) {
        System.err.println("JWT token is unsupported: " + e.getMessage());
        }
        catch (IllegalArgumentException e) {
        System.err.println("JWT claims string is empty: " + e.getMessage());
        }
        return false;
    }
}
