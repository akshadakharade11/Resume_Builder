package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Platform;

public interface PlatformRepository extends JpaRepository<Platform,Long> {

}
