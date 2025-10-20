package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Achievement;
public interface AchievementRepository extends JpaRepository<Achievement,Long>{
    List<Achievement> findByProfileId(Long profileId);

}
