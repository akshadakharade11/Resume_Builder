package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Experience;
import com.example.demo.services.ExperienceService;

@RestController
	@RequestMapping("/api/experiences")
	public class ExperienceController {

	     @Autowired
	    private ExperienceService experienceService;

	  
	    //  Add new experience
	    @PostMapping
	    public ResponseEntity<Experience> addExperience(@RequestBody Experience experience) {
	        try {
	            Experience savedExp = experienceService.addExperience(experience);
	            return ResponseEntity.ok(savedExp);
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.badRequest().body(null);
	        }
	    }

	    //  Get experience by profile ID
	    @GetMapping("/profile/{profileId}")
	    public ResponseEntity<Experience> getExperiencesByProfile(@PathVariable Long profileId) {
	        return experienceService.getExperiencesByProfile(profileId)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    // Update experience
	    @PutMapping("/{id}")
	    public ResponseEntity<Experience> updateExperience(@PathVariable Long id, @RequestBody Experience updatedExp) {
	        try {
	            Experience updated = experienceService.updateExperience(id, updatedExp);
	            return ResponseEntity.ok(updated);
	        } catch (RuntimeException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    //  Delete experience
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteExperience(@PathVariable Long id) {
	        experienceService.deleteExperience(id);
	        return ResponseEntity.noContent().build();
	    }
	}



