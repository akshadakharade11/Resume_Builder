package com.example.demo.services;

	import com.example.demo.entity.Achievement;
	import com.example.demo.entity.Profile;
	import com.example.demo.repository.AchievementRepository;
	import com.example.demo.repository.ProfileRepository;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import java.util.List;

	@Service
	public class AchievementService {

	    @Autowired
	    private AchievementRepository achievementRepository;

	    @Autowired
	    private ProfileRepository profileRepository;

	    // Create new achievement
	    public Achievement addAchievement(Long profileId, Achievement achievement) {
	        Profile profile = profileRepository.findById(profileId)
	                .orElseThrow(() -> new RuntimeException("Profile not found"));

	        achievement.setProfile(profile);
	        return achievementRepository.save(achievement);
	    }

	    // Get all achievements
	    public List<Achievement> getAllAchievements() {
	        return achievementRepository.findAll();
	    }

	    // Get achievements for a specific profile
	    public List<Achievement> getAchievementsByProfile(Long profileId) {
	        return achievementRepository.findByProfileId(profileId);
	    }

	    // Update achievement
	    public Achievement updateAchievement(Long id, Achievement updatedAchievement) {
	        Achievement existing = achievementRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Achievement not found"));

	        existing.setTitle(updatedAchievement.getTitle());
	        existing.setDescription(updatedAchievement.getDescription());
	        existing.setDate(updatedAchievement.getDate());
	        existing.setOrganization(updatedAchievement.getOrganization());
	        return achievementRepository.save(existing);
	    }

	    // Delete achievement
	    public void deleteAchievement(Long id) {
	        achievementRepository.deleteById(id);
	    }
}