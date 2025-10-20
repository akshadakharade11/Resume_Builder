package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Activity1;

public interface ActivityRepository extends JpaRepository<Activity1,Long>{
    List<Activity1> findByUserId(Long userId);

}
