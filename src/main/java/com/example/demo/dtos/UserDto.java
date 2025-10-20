package com.example.demo.dtos;

import com.example.demo.entity.Profile;

public class UserDto {
	
	public Long id;
    public String name;
    public String email;
    public String password;
    public String role;
    public Profile profile;

    public UserDto() {}
    
    public UserDto(Long id,String name,String emial,String password,String role,Profile profile)
    {
     this.id = id; 
     this.name=name;
     this.email = emial;
     this.password = password;
     this.role = role;
     this.profile = profile;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}
