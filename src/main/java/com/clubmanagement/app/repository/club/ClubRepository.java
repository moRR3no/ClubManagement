package com.clubmanagement.app.repository.club;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {

    //here are implemented CRUD operations.
    //you can also implement some methods by yourself to manage DB
    // f.e.: List<Club> findByNameStartsWithI(String name);

}
