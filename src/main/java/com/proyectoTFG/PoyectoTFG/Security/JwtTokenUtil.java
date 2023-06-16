package com.proyectoTFG.PoyectoTFG.Security;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil {

    //private static final String SECRET_KEY = "proyectoTFG";
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days

    private static final String SECRET_KEY = "unaClaveSecretaMuyLargaQueNadiePuedeAdivinar";




    // Generar token JWT firmado con clave privada
    public String generateToken(UserDetails userDetails){
        //recuperar los roles del usuario
        List<String> roles = userDetails.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toList());


        return Jwts.builder()
            //.setClaims(claims)
            .claim("roles", roles)
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
            .compact();
    }

    // Verificar token JWT con clave pública
    public boolean validateToken(String token) {


        //token recibido
        System.out.println("Token recibido: " + token);

        try {
            Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes())).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            System.out.println("Error al validar el token: " + e.getMessage());
            return false;
        }
    }

    public String getSecretKey() {
        return SECRET_KEY;
    }

    /* public boolean validateToken(String token, UserDetails userDetails){
        String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public String extractUsername(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    private boolean isTokenExpired(String token){
        Date expirationDate = Jwts.parser().setSigningKey(token).parseClaimsJws(token).getBody().getExpiration();
        return expirationDate.before(new Date());
    } */
    
}
