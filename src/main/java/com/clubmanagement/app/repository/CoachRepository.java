package com.clubmanagement.app.repository;

import com.clubmanagement.app.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {
}
