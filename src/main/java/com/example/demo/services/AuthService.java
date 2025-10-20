package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.AuthResponse;
import com.example.demo.dtos.UserLoginRequest;
import com.example.demo.dtos.UserRegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JWTUtil;

@Service
public class AuthService {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	public AuthResponse register(UserRegisterRequest request) {
		User user = new User();
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        } 
        // create and save user

		user.setName(request.name);
		user.setEmail(request.email);
		user.setPassword(passwordEncoder.encode(request.password));
		user.setRole(request.role);
		userRepository.save(user);

		String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
		return new AuthResponse(token);

	}

	public AuthResponse login(UserLoginRequest request) {

		User user = userRepository.findByEmail(request.email).orElseThrow(() -> new RuntimeException("User not found"));

		if (!passwordEncoder.matches(request.password, user.getPassword()))
			throw new RuntimeException("Invalid credentials");

		String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
		return new AuthResponse(token);

	}
	
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }


}
