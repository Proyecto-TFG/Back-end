package com.proyectoTFG.PoyectoTFG.Security;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.proyectoTFG.PoyectoTFG.entities.Rol;
import com.proyectoTFG.PoyectoTFG.entities.Usuario;
import com.proyectoTFG.PoyectoTFG.entities.UsuarioRol;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;


@Component
public class JwtTokenUtil {
    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000;// 24 hours

    
    private String SECRET_KEY = "codigoPrivado";

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);

    public String generateAccessToken(Usuario user) {
        List<String> roleNames = user.getRoles().stream()
                .map(UsuarioRol::getRol)
                .map(Rol::getNombre)
                .collect(Collectors.toList());
        System.out.println("roleNames: " + roleNames);
        return Jwts.builder()
                .setSubject(String.format("%s,%s", user.getId(), user.getUserName()))
                .setIssuer("CodeJava")
                .claim("roles", roleNames)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public boolean validateAccessToken(String token){
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            LOGGER.error("Token has expired", ex.getMessage());
        }catch (IllegalArgumentException ex){
            LOGGER.error("Token is null, empty or only whitespace", ex.getMessage());
        }catch (MalformedJwtException ex){
            LOGGER.error("Token is invalid", ex.getMessage());
        }catch (UnsupportedJwtException ex) {
           LOGGER.error("JWT is not supported", ex);
        }catch (SignatureException ex) {
            LOGGER.error("Signature validation failed");
        }


        return false;
    }

    public String getSubject(String token){
        return parseClaims(token).getSubject();
    }

    public Claims parseClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY)
            .parseClaimsJws(token).getBody();
    }

    

}
