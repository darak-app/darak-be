package com.darakapp.darak.repository.jpa;

import com.darakapp.darak.entity.ChatroomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatroomUserRepository extends JpaRepository<ChatroomUser,Long> {
}
