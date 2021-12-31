package com.dmittrey.WebLab4Back.DAO;

import com.dmittrey.WebLab4Back.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Override
    <S extends User> S save(S userEntity);
}
