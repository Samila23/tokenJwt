package com.token.services;

public interface TokenService {
    public Boolean validateTokenAndGetClaims(String token);
}
