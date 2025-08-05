package com.darakapp.darak.repository.jpa;

import com.darakapp.darak.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByPhoneNumberHash(String phoneNumberHash);
}
