package com.darakapp.darak.repository;

import com.darakapp.darak.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 필요하면 사용자 정의 메서드 추가 가능
    User findByUsername(String username);
    Boolean existsByUsername(String username);
}
