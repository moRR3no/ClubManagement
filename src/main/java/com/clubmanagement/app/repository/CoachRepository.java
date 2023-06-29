package com.clubmanagement.app.repository;

import com.clubmanagement.app.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {

    Coach findByClubId (Long clubId);

    @Transactional
    void deleteByClubId (Long clubId);
}
