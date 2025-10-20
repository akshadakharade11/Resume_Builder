package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToMany
    @JoinTable(
        name = "profile_skills",
        joinColumns = @JoinColumn(name = "profile_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills = new HashSet<>();
    private String skillName;
    private String proficiencyLevel; // e.g., Beginner, Intermediate, Expert

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
    
    public Skill() {}
    
    public Skill(long id,String skillName,String proficiencyLevel,Profile profile) {
    	
    	this.id = id;
    	this.skillName = skillName;
    	this.proficiencyLevel = proficiencyLevel;
    	this.profile = profile;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getProficiencyLevel() {
		return proficiencyLevel;
	}

	public void setProficiencyLevel(String proficiencyLevel) {
		this.proficiencyLevel = proficiencyLevel;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
    
	  public Set<Skill> getSkills() {
	        return skills;
	    }

	    public void setSkills(Set<Skill> skills) {
	        this.skills = skills;
	    }
	
	
}
