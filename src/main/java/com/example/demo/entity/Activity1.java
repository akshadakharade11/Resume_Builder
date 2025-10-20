package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


//Activity ->A student completes a course on Coursera → Coursera API sends data
//→ your Activity Service saves it in the system → the Resume Builder auto-updates the resume with the verified course details.

@Entity
@Table(name="activities")
public class Activity1 {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String platform; // Internshala, Coursera, Devpost
    private String type; // Internship, Course, Hackathon
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String certificateUrl;
    private boolean verified;
    @ManyToOne
    private User user;
    
    public Activity1() {}
    
	public Activity1(Long id, String platform, String type, String title, String description, LocalDate startDate,
			LocalDate endDate, String certificateUrl, boolean verified, User user) {
		super();
		this.id = id;
		this.platform = platform;
		this.type = type;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.certificateUrl = certificateUrl;
		this.verified = verified;
		this.user = user;
		
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getCertificateUrl() {
		return certificateUrl;
	}

	public void setCertificateUrl(String certificateUrl) {
		this.certificateUrl = certificateUrl;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    

}
