package com.darakapp.darak.repository.mongo;

import com.darakapp.darak.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<Message,Long> {
    Page<Message> findByChatRoomId(Long chatRoomId, Pageable pageable);
}
