package com.example.demo.controller;

	
	
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Activity1;
import com.example.demo.repository.ActivityRepository;
import com.example.demo.services.ActivityService;

import java.util.List;

	@RestController
	@RequestMapping("/api/integration")
	public class ActivityController {

		@Autowired
	    private final ActivityService activityService;
		
		@Autowired
	    private final ActivityRepository activityRepository;

	    public ActivityController(ActivityService activityService, ActivityRepository activityRepository) {
	        this.activityService = activityService;
	        this.activityRepository = activityRepository;
	    }

	    @PostMapping("/fetch/internships/{userId}")
	    public String fetchInternships(@PathVariable Long userId) {
	    	activityService.fetchInternships(userId);
	        return "Internships synced successfully!";
	    }

	    @PostMapping("/fetch/courses/{userId}")
	    public String fetchCourses(@PathVariable Long userId) {
	    	activityService.fetchCourses(userId);
	        return "Courses synced successfully!";
	    }

	    @PostMapping("/fetch/hackathons/{userId}")
	    public String fetchHackathons(@PathVariable Long userId) {
	    	activityService.fetchHackathons(userId);
	        return "Hackathons synced successfully!";
	    }

	    @GetMapping("/activities/{userId}")
	    public List<Activity1> getActivities(@PathVariable Long userId) {
	        return activityRepository.findByUserId(userId);
	    }
	}


