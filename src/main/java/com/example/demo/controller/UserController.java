package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dtos.AuthResponse;
import com.example.demo.dtos.UserLoginRequest;
import com.example.demo.dtos.UserRegisterRequest;
import com.example.demo.dtos.UserResponse;
import com.example.demo.entity.User;
import com.example.demo.services.AuthService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/register")
	public ResponseEntity<AuthResponse> register(@RequestBody UserRegisterRequest request) {
		return ResponseEntity.ok(authService.register(request));
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody UserLoginRequest request) {
		return ResponseEntity.ok(authService.login(request));
	}
}
