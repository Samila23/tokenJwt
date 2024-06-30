package com.token.model.unums;

import java.util.logging.Logger;

import com.token.utils.validationsUtils;

public enum RolesEnum {
	
	ADMIN("Admin"),MEMBER("Member"),EXTERNAL("External");
    
	private static final Logger logger = Logger.getLogger(RolesEnum.class.getName());


	String desRole;

	public String getDesRole() {
		return desRole;
	}

	private RolesEnum(String desRole) {
		this.desRole = desRole;
	}
	
	public static boolean findByRole(final String descRole) {
		final Integer VALID_CASE = 0;
		for(final RolesEnum role : RolesEnum.values()) {
			if(role.getDesRole().compareToIgnoreCase(descRole.toLowerCase()) == VALID_CASE){
				return true;
			}
		}
		logger.info("ClaimsRoleEnum - validateRole() - INVALID ");
		return false;
	}
}
