package com.clubmanagement.app.repository;

import com.clubmanagement.app.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {

    List<Player> findByClubId (Long clubId);

    @Transactional
    void deleteByClubId (Long clubId);

}
