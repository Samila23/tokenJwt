package com.token.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.token.model.ClaimsDto;
import com.token.utils.validationsUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;


@Service
public class TokenServiceImpl implements TokenService {
	@Value("${jwt.secret}") // Configuração do segredo do JWT (opcional)
    private String jwtSecret;

	
	public Boolean validateTokenAndGetClaims(String token) {

        try {
        	ClaimsDto claimsDto = new ClaimsDto();
        	
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtSecret) // Verificar assinatura usando o segredo
                    .parseClaimsJws(token)
                    .getBody();
            
            claimsDto.setName(claims.get("Name").toString());
            claimsDto.setRole(claims.get("Role").toString());
            claimsDto.setSeed(claims.get("Seed").toString());
            
            if(validationsUtils.validateName(claimsDto)// 
            		&& validationsUtils.validateSeed(claimsDto)//
            		&& validationsUtils.validateRole(claimsDto)//
            		&& validationsUtils.validateClaim(claims)
            		) {
            	return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (JwtException e) {
            System.err.println("Erro JWT ao validar o token: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println("Erro geral ao validar o token JWT: " + e.getMessage());
            return false; 
        }
	}

}
