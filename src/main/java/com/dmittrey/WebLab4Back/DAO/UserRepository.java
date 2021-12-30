package com.dmittrey.WebLab4Back.DAO;

import com.dmittrey.WebLab4Back.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Override
    <S extends UserEntity> S save(S userEntity);

    Optional<UserEntity> findBySessionId(String sessionId);
}
