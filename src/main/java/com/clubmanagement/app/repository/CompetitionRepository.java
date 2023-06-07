package com.clubmanagement.app.repository;

import com.clubmanagement.app.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}
