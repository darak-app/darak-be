package com.darakapp.darak.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.Instant;

@Entity
@Table(name = "chatrooms_users")
@Getter
@NoArgsConstructor
public class ChatroomUser {
    @EmbeddedId
    private ChatroomUserId chatroomUserId;

    private Instant joinedAt;
}
