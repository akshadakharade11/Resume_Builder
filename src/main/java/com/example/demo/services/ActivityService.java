package com.example.demo.services;
	
	import org.springframework.stereotype.Service;
	import org.springframework.web.client.RestTemplate;

import com.example.demo.dtos.InternshipResponse;
import com.example.demo.entity.Activity1;
import com.example.demo.entity.User;
import com.example.demo.repository.ActivityRepository;

import java.util.List;

	@Service
	public class ActivityService {

	    private final ActivityRepository activityRepository;
	    private final RestTemplate restTemplate;

	    public ActivityService(ActivityRepository activityRepository) {
	        this.activityRepository = activityRepository;
	        this.restTemplate = new RestTemplate();
	    }

	    // Fetch internships from an external API (example)
	    public void fetchInternships(Long userId) {
	        String url = "https://api.internshala.com/user/" + userId + "/internships";
	        InternshipResponse[] responses = restTemplate.getForObject(url, InternshipResponse[].class);

	        for (InternshipResponse r : responses) {
	            Activity1 activity = new Activity1();
	            activity.setPlatform("Internshala");
	            activity.setType("Internship");
	            activity.setTitle(r.getTitle());
	            activity.setDescription(r.getDescription());
	            activity.setStartDate(r.getStartDate());
	            activity.setEndDate(r.getEndDate());
	            activity.setCertificateUrl(r.getCertificateUrl());
	            activity.setVerified(r.isVerified());

	            User user = new User();
	            user.setId(userId);
	            activity.setUser(user);

	            activityRepository.save(activity);
	        }
	    }

	    //fetchCourses()
	    public void fetchCourses(Long userId) {
	        String url = "https://api.internshala.com/user/" + userId + "/internships";
	        InternshipResponse[] responses = restTemplate.getForObject(url, InternshipResponse[].class);

	        for (InternshipResponse r : responses) {
	            Activity1 activity = new Activity1();
	            activity.setPlatform("Internshala");
	            activity.setType("Internship");
	            activity.setTitle(r.getTitle());
	            activity.setDescription(r.getDescription());
	            activity.setStartDate(r.getStartDate());
	            activity.setEndDate(r.getEndDate());
	            activity.setCertificateUrl(r.getCertificateUrl());
	            activity.setVerified(r.isVerified());

	            User user = new User();
	            user.setId(userId);
	            activity.setUser(user);

	            activityRepository.save(activity);
	        }
	    }

	    //fetchHackathons()

	    public void fetchHackathons(Long userId) {
	        String url = "https://api.internshala.com/user/" + userId + "/internships";
	        InternshipResponse[] responses = restTemplate.getForObject(url, InternshipResponse[].class);

	        for (InternshipResponse r : responses) {
	            Activity1 activity = new Activity1();
	            activity.setPlatform("Internshala");
	            activity.setType("Internship");
	            activity.setTitle(r.getTitle());
	            activity.setDescription(r.getDescription());
	            activity.setStartDate(r.getStartDate());
	            activity.setEndDate(r.getEndDate());
	            activity.setCertificateUrl(r.getCertificateUrl());
	            activity.setVerified(r.isVerified());

	            User user = new User();
	            user.setId(userId);
	            activity.setUser(user);

	            activityRepository.save(activity);
	        }
	    }
	}