package com.ocire.boottest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class User extends BaseModel {
	
	@Column(name = "username", length = 20, nullable = false)
	private String username;

	@Column(name = "user_password", length = 20, nullable = false)
	private String userPassword;
	
	@ManyToOne
	@JoinColumn(name = "id_role")
	private Role role;
	
	@OneToOne
	@JoinColumn(name = "id_profile")
	private Profile profile;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}
