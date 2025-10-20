package com.example.demo.dtos;
	import jakarta.validation.constraints.Email;
	import jakarta.validation.constraints.NotBlank;
	import lombok.Getter;
	import lombok.Setter;

	@Getter
	@Setter
	public class UserLoginRequest {

	    @Email(message = "Invalid email format")
	    @NotBlank(message = "Email is required")
		public String email;

	    @NotBlank(message = "Password cannot be blank")
	    public String password;
	    
	    
	    
	}



