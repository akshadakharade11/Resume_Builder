package com.example.demo.services;

	import com.example.demo.entity.Experience;
	import com.example.demo.repository.ExperienceRepository;
	import org.springframework.stereotype.Service;
	import java.util.List;
import java.util.Optional;

	@Service
	public class ExperienceService {

	    private final ExperienceRepository repo;

	    public ExperienceService(ExperienceRepository repo) {
	        this.repo = repo;
	    }

	    public Experience addExperience(Experience exp) {
	        if (exp.getCompanyName() == null || exp.getDesignation() == null) {
	            throw new IllegalArgumentException("Company name and designation are required");
	        }
	        return repo.save(exp);
	    }

	    public Optional<Experience> getExperiencesByProfile(Long profileId) {
	        return repo.findById(profileId);
	    }

	    public Experience updateExperience(Long id, Experience updatedExp) {
	        Experience exp = repo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Experience not found"));
	        exp.setCompanyName(updatedExp.getCompanyName());
	        exp.setDesignation(updatedExp.getDesignation());
	        exp.setLocation(updatedExp.getLocation());
	        exp.setStartDate(updatedExp.getStartDate());
	        exp.setEndDate(updatedExp.getEndDate());
	        exp.setCurrentlyWorking(updatedExp.isCurrentlyWorking());
	        exp.setDescription(updatedExp.getDescription());
	        return repo.save(exp);
	    }

	    public void deleteExperience(Long id) {
	        repo.deleteById(id);
	    }
}
