package com.example.demo.security;

import java.util.Date;
import java.util.jar.JarException;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JWTUtil {
			
		private final String secret ="zidio_secrete_key";
		private final long expiration = 86400000;
		
		public String generateToken(String email, String role) {
	        return Jwts.builder()
	                .setSubject(email)
	                .claim("role", role)
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + expiration))
	                .signWith(SignatureAlgorithm.HS512, secret)
	                .compact();
	    }
		
	    public String extractUsername(String token) {
	        return Jwts.parser().setSigningKey(secret)
	                .parseClaimsJws(token).getBody().getSubject();
	    }
	    public boolean validationToken(String token) throws JarException {
	    	Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
	    }
	       
}
