package com.marioparrillamaroto.serverEventos.services;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("JWTService")
public class JWTService {
    private static final String BEARER = "Bearer ";
    private static final String HEADER  = "Authorization";

    @Value("${jwt.secret}")
    private String SECRET;

    
	public boolean validateToken(HttpServletRequest request) throws Exception {
        try {
            Key key = new SecretKeySpec(SECRET.getBytes(), SignatureAlgorithm.HS256.getJcaName());
            String jwtToken = request.getHeader(HEADER).replace(BEARER, "");
            Claims c = Jwts.parser().setSigningKey(key).parseClaimsJws(jwtToken).getBody();
            return isTokenExpired(c);
        } catch (Exception e) {
            return false;
        }
	}
        

    public Boolean isTokenExpired(Claims claim) {
        try {
            Long expiration = Long.parseLong(claim.get("exp").toString());
            return new Date().before(new Date(expiration*1000L));
        } catch (Exception e) {
            return false;
        }
    }

}
