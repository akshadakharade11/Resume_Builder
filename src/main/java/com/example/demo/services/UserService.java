package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dtos.UserDto;
import com.example.demo.entity.Profile;
import com.example.demo.entity.User;
import com.example.zidio.repository.UserRepository;


public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	

}
