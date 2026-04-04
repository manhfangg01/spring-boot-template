package com.osamuharu.user.domain.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	
	public void changeFirstName(String firstName) {
		if (firstName == null) {
			return;
		}
		
		this.firstName = firstName;
	}
	
	public void changeLastName(String lastName) {
		if (lastName == null) {
			return;
		}
		
		this.lastName = lastName;
	}
	
	public void changeUsername(String username) {
		if (username == null) {
			return;
		}
		
		this.username = username;
	}
	
	public void changeEmail(String email) {
		if (email == null) {
			return;
		}
		
		this.email = email;
	}
}
