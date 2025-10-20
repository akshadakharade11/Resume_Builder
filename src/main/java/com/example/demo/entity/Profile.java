package com.example.demo.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name="profiles")
public class Profile {
	
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String summary;
    private String education;
    private String contactInfo;

    private Set<Skill> skills = new HashSet<>();
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<Activity1> activities;
    
    
    public Profile() {}
   
	public Profile(Long id, String summary, String education, String contactInfo, User user,
			List<Activity1> activities) {
		super();
		this.id = id;
		this.summary = summary;
		this.education = education;
		this.contactInfo = contactInfo;
		this.user = user;
		this.activities = activities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Activity1> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity1> activities) {
		this.activities = activities;
	}    
	
	  public Set<Skill> getSkills() {
	        return skills;
	    }

	    public void setSkills(Set<Skill> skills) {
	        this.skills = skills;
	    }
	
}
