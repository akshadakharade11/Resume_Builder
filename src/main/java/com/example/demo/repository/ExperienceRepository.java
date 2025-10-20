package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Experience;

public interface ExperienceRepository extends JpaRepository<Experience,Long>{

	Optional<Experience> findById(Long id);
	
}
