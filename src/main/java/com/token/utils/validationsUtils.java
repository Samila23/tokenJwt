package com.token.utils;

import java.util.Set;
import java.util.logging.Logger;

import com.token.model.ClaimsDto;
import com.token.model.unums.ClaimsEnum;
import com.token.model.unums.RolesEnum;

import io.jsonwebtoken.Claims;

public class validationsUtils {
    //private static final Logger logger = LoggerFactory.getLogger(validationsUtils.class);
    private static final Logger logger = Logger.getLogger(validationsUtils.class.getName());

	public static Boolean validateName(ClaimsDto claims ) {
		logger.info("IN - validationsUtils.class - validateName()");
		if(!(claims.getName() == null) && !claims.getName().isEmpty()) {
			if(validationsUtils.validNumber(claims.getName()) && validationsUtils.validSizeName(claims.getName())) {
				return Boolean.TRUE;
			}
		}
		logger.info("OUT - validationsUtils.class - validateName() - INVALID");
		return Boolean.FALSE;
	}
	public static Boolean validNumber(String name) {
		return name.matches(".*\\d+.*") ? Boolean.FALSE : Boolean.TRUE;
	}
	public static Boolean validSizeName(String name) {
		return name.length() <= 256 ? Boolean.TRUE : Boolean.FALSE;
	}
	
	public static Boolean validateSeed(ClaimsDto claims ) {
		logger.info("IN - validationsUtils.class - validateSeed()");
        Integer seed = Integer.parseInt(claims.getSeed());
        if (seed <= 1) {
    		logger.info("OUT - validationsUtils.class - validateSeed() - INVALID");
            return false;
        }
        // Verifica divisibilidade por números de 2 até a raiz quadrada do número
        for (int i = 2; i <= Math.sqrt(seed); i++) {
            if (seed % i == 0) {
        		logger.info("OUT - validationsUtils.class - validateSeed() - INVALID");
                return false; // Encontrou um divisor, não é primo
            }
        }
		return Boolean.TRUE;
	}
	public static Boolean validateRole(ClaimsDto claims ) {
		logger.info("IN - validationsUtils.class - validateRole()");
		return RolesEnum.findByRole(claims.getRole());
	}
	public static Boolean validateClaim(Claims claims) {
		logger.info("IN - validationsUtils.class - validateClaim()");
		Boolean valid = Boolean.FALSE;
		Set<String> nomesClaims = claims.keySet();
	     for (String claim : nomesClaims) {
	    	 valid = ClaimsEnum.findByClaims(claim);
	      }
	     return valid;
	}
}
