package com.example.demo.entity;

	import jakarta.persistence.*;
	import java.time.LocalDate;

	@Entity
	@Table(name = "experiences")
	public class Experience {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String companyName;
	    private String designation;
	    private String location;

	    private LocalDate startDate;
	    private LocalDate endDate;
	    private boolean currentlyWorking;

	    @Column(length = 2000)
	    private String description;

	    @ManyToOne
	    @JoinColumn(name = "profile_id")
	    private Profile profile;
	    
	    public Experience() {}
		public Experience(Long id, String companyName, String designation, String location, LocalDate startDate,
				LocalDate endDate, boolean currentlyWorking, String description, Profile profile) {
			super();
			this.id = id;
			this.companyName = companyName;
			this.designation = designation;
			this.location = location;
			this.startDate = startDate;
			this.endDate = endDate;
			this.currentlyWorking = currentlyWorking;
			this.description = description;
			this.profile = profile;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
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
		public boolean isCurrentlyWorking() {
			return currentlyWorking;
		}
		public void setCurrentlyWorking(boolean currentlyWorking) {
			this.currentlyWorking = currentlyWorking;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Profile getProfile() {
			return profile;
		}
		public void setProfile(Profile profile) {
			this.profile = profile;
		}

}