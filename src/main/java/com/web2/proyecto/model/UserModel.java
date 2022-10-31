package com.web2.proyecto.model;


import java.time.LocalDateTime;
import java.util.Set;

import javax.validation.constraints.Size;

import com.web2.proyecto.entities.UserRole;




public class UserModel {

	private int id;
	
	@Size(min=8, max=20)
	private String username;
	
	@Size(min=8, max=20)
	private String password;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
	

	private boolean enabled;

	


	private Set<UserRole> userRoles;


	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}




	public Set<UserRole> getUserRoles() {
		return userRoles;
	}


	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public UserModel(int id, @Size(min = 8, max = 20) String username, @Size(min = 8, max = 20) String password,
			LocalDateTime createdAt, LocalDateTime updatedAt, boolean enabled,
			 Set<UserRole> userRoles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.enabled = enabled;
		this.userRoles = userRoles;
	}


}
