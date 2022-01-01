package com.dmittrey.WebLab4Back.DAO;

import com.dmittrey.WebLab4Back.entities.Hit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HitRepo extends JpaRepository<Hit, Long> {

    void deleteAllByUserUsername(String username);

    List<Hit> findAllByUserUsername(String username);
}
