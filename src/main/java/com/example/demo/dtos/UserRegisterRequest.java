package com.example.demo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterRequest {
	
	
    public static final String role = null;

	@NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 50, message = "Name must be between 3–50 characters")
	public String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    public String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, max = 20, message = "Password must be 6–20 characters")
    public String password;

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
}
