package com.token.model.unums;

import java.util.logging.Logger;

import com.token.utils.validationsUtils;

public enum ClaimsEnum {
	NAME("Name"),ROLE("Role"),SEED("Seed");
	
	private static final Logger logger = Logger.getLogger(ClaimsEnum.class.getName());

	String descClaims;

	public String getDescClaim() {
		return descClaims;
	}

	private ClaimsEnum(String descClaims) {
		this.descClaims = descClaims;
	}

	public static boolean findByClaims(final String descClaims) {
		final Integer VALID_CASE = 0;
		for(final ClaimsEnum claims : ClaimsEnum.values()) {
			if(claims.getDescClaim().compareToIgnoreCase(descClaims.toLowerCase()) == VALID_CASE){
				return true;
			}
		}
		logger.info("ClaimsRoleEnum - findByClaims() - INVALID ");
		return false;
	}

}
