package com.hamzadev.uploadreadcsv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hamzadev.uploadreadcsv.model.Tutorial;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}
