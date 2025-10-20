package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.*;


//platfrom ->A student completes a course on Coursera → Coursera API sends data → your Actitvity Service saves it in the system 
//→ the Resume Builder auto-updates the resume with the verified course details.


@Entity
@Table(name = "platforms")
public class Platform {

	    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String apiUrl;
	    private String authToken;

	    @OneToMany(mappedBy = "platform")
	    private List<Activity1> activities;
	    
	    public Platform() {}
		public Platform(Long id, String name, String apiUrl, String authToken, List<Activity1> activities) {
			super();
			this.id = id;
			this.name = name;
			this.apiUrl = apiUrl;
			this.authToken = authToken;
			this.activities = activities;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getApiUrl() {
			return apiUrl;
		}

		public void setApiUrl(String apiUrl) {
			this.apiUrl = apiUrl;
		}

		public String getAuthToken() {
			return authToken;
		}

		public void setAuthToken(String authToken) {
			this.authToken = authToken;
		}

		public List<Activity1> getActivities() {
			return activities;
		}

		public void setActivities(List<Activity1> activities) {
			this.activities = activities;
		}
	    
	    
	    
	    
	}
