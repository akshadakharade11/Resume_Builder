package com.example.demo.services;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.example.demo.entity.Platform;
import com.example.demo.repository.PlatformRepository;

import java.util.List;

	@Service
	public class PlatformService {

	    @Autowired
	    private PlatformRepository platformRepository;

	    public Platform registerPlatform(Platform platform) {
	        return platformRepository.save(platform);
	    }

	    public List<Platform> getAllPlatforms() {
	        return platformRepository.findAll();
	    }

	    public Platform getPlatformById(Long id) {
	        return platformRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Platform not found"));
	    }
	}

