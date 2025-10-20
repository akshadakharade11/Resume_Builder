package com.example.demo.services;

	import com.example.demo.entity.Skill;
	import com.example.demo.repository.SkillRepository;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import java.util.List;

	@Service
	public class SkillService {

	    @Autowired
	    private SkillRepository skillRepository;

	    public List<Skill> getAllSkills() {
	        return skillRepository.findAll();
	    }

	    public Skill addSkill(Skill skill) {
	        if (skillRepository.existByName(skill.getSkillName())) {
	            throw new RuntimeException("Skill already exists: " + skill.getSkillName());
	        }
	        return skillRepository.save(skill);
	    }

	    public Skill updateSkill(Long id, Skill updatedSkill) {
	        Skill skill = skillRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Skill not found"));
	        skill.setSkillName(updatedSkill.getSkillName());
	        skill.setProficiencyLevel(updatedSkill.getProficiencyLevel());
	        return skillRepository.save(skill);
	    }

	    public void deleteSkill(Long id) {
	        skillRepository.deleteById(id);
	    }
}
