package com.example.entities;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "userInfos")
public class UserInfo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message="name is required")
	@Column(name = "name", nullable = false, length = 20)
	private String name;
	
	@NotBlank(message="email is required")
	@Size(max = 50)
	@Email
	@Column(unique = true)
	private String email;
	
	@NotBlank(message="username is required")
	@Size(max = 20)
	@Column(unique = true,columnDefinition = "VARCHAR(255) COLLATE utf8_bin")
	private String username;
	
	@NotBlank(message="password is required")
	@Size(max = 120)
	@Column(unique = true,columnDefinition = "VARCHAR(255) COLLATE utf8_bin")
	private String password;
	
	@NotBlank(message = "Location is required")
    @Size(max = 100)
	private String location;
	
	@NotNull(message = "Birthday is required")
    @Past(message = "Birthday must be in the past")
	private Date dateOfBirth;
	
	@OneToOne(mappedBy = "userInfo", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private UserProfile userProfile;

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
