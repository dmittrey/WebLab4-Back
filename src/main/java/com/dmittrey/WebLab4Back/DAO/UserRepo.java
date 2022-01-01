package com.dmittrey.WebLab4Back.DAO;

import com.dmittrey.WebLab4Back.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    boolean existsById(Long userId);

    boolean existsByUsername(String username);

    Optional<User> findById(Long userId);

    Optional<User> findByUsername(String username);


}
