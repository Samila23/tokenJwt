package com.token.model;

public class ClaimsDto {
	private String name;
	private String Role;
	private String Seed;

	
	public ClaimsDto() {
	}
	public ClaimsDto(String name, String role, String seed) {
		super();
		this.name = name;
		Role = role;
		Seed = seed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getSeed() {
		return Seed;
	}
	public void setSeed(String seed) {
		Seed = seed;
	}
	
	
}
