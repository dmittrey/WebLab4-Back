package com.dmittrey.WebLab4Back.DAO;

import com.dmittrey.WebLab4Back.entities.HitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HitRepository extends JpaRepository<HitEntity, Long> {

    @Override
    <S extends HitEntity> S save(S hitEntity);

//    void deleteAllByUserEntitySessionId(String sessionId);

//    List<HitEntity> findAllByUserEntitySessionId(String sessionId);
}
