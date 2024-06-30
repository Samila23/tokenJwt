package com.token.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.token.services.TokenService;

@RestController
@RequestMapping("token")
public class tokenController {
	
	@Autowired
	private TokenService clienteService;
	
	
	@GetMapping("")
	public ResponseEntity<Boolean> validToken(@RequestHeader("Authorization") String authorizationHeader) {
		String a = authorizationHeader;
		return ResponseEntity.ok(clienteService.validateTokenAndGetClaims(authorizationHeader));
	}

}
