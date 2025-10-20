package com.example.demo.controller;

	import com.example.demo.entity.Skill;
import com.example.demo.services.SkillService;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

	import java.util.List;

	@RestController
	@RequestMapping("/api/skills")
	public class SkillController {

	    @Autowired
	    private SkillService skillService;

	    @GetMapping
	    public ResponseEntity<List<Skill>> getAllSkills() {
	        return ResponseEntity.ok(skillService.getAllSkills());
	    }

	    @PostMapping
	    public ResponseEntity<Skill> addSkill(@RequestBody Skill skill) {
	        return ResponseEntity.ok(skillService.addSkill(skill));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Skill> updateSkill(@PathVariable Long id, @RequestBody Skill skill) {
	        return ResponseEntity.ok(skillService.updateSkill(id, skill));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteSkill(@PathVariable Long id) {
	        skillService.deleteSkill(id);
	        return ResponseEntity.ok("Skill deleted successfully");
	    }
}