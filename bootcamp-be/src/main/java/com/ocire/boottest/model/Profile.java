package com.ocire.boottest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_profile")
public class Profile extends BaseModel {

	@Column(name = "full_name", length = 30, nullable = false)
	private String fullName;
	
	@Column(name = "phone_numb", length = 12, nullable = false)
	private String phoneNumb;
	
	@ManyToOne
	@JoinColumn(name = "profile_photo")
	private File profilePhoto;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumb() {
		return phoneNumb;
	}

	public void setPhoneNumb(String phoneNumb) {
		this.phoneNumb = phoneNumb;
	}

	public File getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(File profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
}
