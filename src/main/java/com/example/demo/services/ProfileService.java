package com.example.demo.services;

	import com.example.demo.entity.Profile;
	import com.example.demo.entity.Skill;
	import com.example.demo.repository.ProfileRepository;
	import com.example.demo.repository.SkillRepository;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import java.util.HashSet;
	import java.util.Set;

	@Service
	public class ProfileService {

	    @Autowired
	    private ProfileRepository profileRepository;

	    @Autowired
	    private SkillRepository skillRepository;

	    public Profile addSkillToProfile(Long profileId, Long skillId) {
	        Profile profile = profileRepository.findById(profileId)
	                .orElseThrow(() -> new RuntimeException("Profile not found"));
	        Skill skill = skillRepository.findById(skillId)
	                .orElseThrow(() -> new RuntimeException("Skill not found"));

	        profile.getSkills().add(skill);
	        return profileRepository.save(profile);
	    }

	    public Profile removeSkillFromProfile(Long profileId, Long skillId) {
	        Profile profile = profileRepository.findById(profileId)
	                .orElseThrow(() -> new RuntimeException("Profile not found"));
	        Skill skill = skillRepository.findById(skillId)
	                .orElseThrow(() -> new RuntimeException("Skill not found"));

	        profile.getSkills().remove(skill);
	        return profileRepository.save(profile);
	    }
	}

