package com.example.demo.controller;

	import com.example.demo.entity.Achievement;
import com.example.demo.services.AchievementService;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

	import java.util.List;

	@RestController
	@RequestMapping("/api/achievements")
	public class AchievementController {

	    @Autowired
	    private AchievementService achievementService;

	    // ✅ Create new achievement for a profile
	    @PostMapping("/{profileId}")
	    public ResponseEntity<Achievement> addAchievement(
	            @PathVariable Long profileId,
	            @RequestBody Achievement achievement) {
	        return ResponseEntity.ok(achievementService.addAchievement(profileId, achievement));
	    }

	    // ✅ Get all achievements
	    @GetMapping
	    public ResponseEntity<List<Achievement>> getAllAchievements() {
	        return ResponseEntity.ok(achievementService.getAllAchievements());
	    }

	    // ✅ Get achievements by profile
	    @GetMapping("/profile/{profileId}")
	    public ResponseEntity<List<Achievement>> getAchievementsByProfile(@PathVariable Long profileId) {
	        return ResponseEntity.ok(achievementService.getAchievementsByProfile(profileId));
	    }

	    // ✅ Update achievement
	    @PutMapping("/{id}")
	    public ResponseEntity<Achievement> updateAchievement(
	            @PathVariable Long id,
	            @RequestBody Achievement achievement) {
	        return ResponseEntity.ok(achievementService.updateAchievement(id, achievement));
	    }

	    // ✅ Delete achievement
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteAchievement(@PathVariable Long id) {
	        achievementService.deleteAchievement(id);
	        return ResponseEntity.ok("Achievement deleted successfully");
	    }
}
