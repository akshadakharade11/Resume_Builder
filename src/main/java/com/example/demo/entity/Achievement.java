package com.example.demo.entity;
	import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

	@Entity
	@Table(name = "achievements")
	public class Achievement {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
       
	    @NotBlank(message = "Title cannot be blank")
	    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
	   
	    @NotBlank(message = "Description cannot be blank")
	    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
	    private String title;           // e.g. "Winner - Hackathon 2025"
	    
	    private String description;     // e.g. "Developed an AI-based resume builder"
	    
	    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date must be in format YYYY-MM-DD")
	    private String date;            // e.g. "2025-02-15"
	    
	    
	    @NotBlank(message = "Organization cannot be blank")
	    private String organization;    // e.g. "Google" or "College TechFest"

	    
	   // Optional — link to Profile
	    @ManyToOne
	    @JoinColumn(name = "profile_id")
	    private Profile profile;

	    public Achievement() {}

	    public Achievement(String title, String description, String date, String organization, Profile profile) {
	        this.title = title;
	        this.description = description;
	        this.date = date;
	        this.organization = organization;
	        this.profile = profile;
	    }

	    // Getters and setters
	    public Long getId() { return id; }

	    public String getTitle() { return title; }
	    public void setTitle(String title) { this.title = title; }

	    public String getDescription() { return description; }
	    public void setDescription(String description) { this.description = description; }

	    public String getDate() { return date; }
	    public void setDate(String date) { this.date = date; }

	    public String getOrganization() { return organization; }
	    public void setOrganization(String organization) { this.organization = organization; }

	    public Profile getProfile() { return profile; }
	    public void setProfile(Profile profile) { this.profile = profile; }
	}


