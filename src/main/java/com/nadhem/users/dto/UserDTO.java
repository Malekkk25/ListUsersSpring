package com.nadhem.users.dto;

import java.util.List;

import com.nadhem.users.entities.Role;

import lombok.Builder;

@Builder
public class UserDTO {
	private Long user_id;
	private String username;
	private String password,email;
	private Boolean enabled;
	private List<Role> roles;
	public UserDTO(Long user_id, String username, String password, String email, Boolean enabled, List<Role> roles) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.roles = roles;
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	

}
