package com.darakapp.darak.repository.jpa;

import com.darakapp.darak.entity.Chatroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatroomRepository extends JpaRepository<Chatroom, Long> {
}
