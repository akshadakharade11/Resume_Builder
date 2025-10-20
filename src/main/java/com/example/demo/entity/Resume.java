package com.example.demo.entity;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "resumes")
public class Resume {

	    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @OneToOne
	    @JoinColumn(name = "user_id")
	    private User user;
	    @Lob
	    private String jsonData;
	    private LocalDateTime lastUpdated;
	   
	   public Resume() {}
		public Resume(Long id, User user, String jsonData, LocalDateTime lastUpdated) {
			super();
			this.id = id;
			this.user = user;
			this.jsonData = jsonData;
			this.lastUpdated = lastUpdated;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public String getJsonData() {
			return jsonData;
		}
		public void setJsonData(String jsonData) {
			this.jsonData = jsonData;
		}
		public LocalDateTime getLastUpdated() {
			return lastUpdated;
		}
		public void setLastUpdated(LocalDateTime lastUpdated) {
			this.lastUpdated = lastUpdated;
		}  
	}
