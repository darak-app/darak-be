package com.darakapp.darak.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Embeddable
@Getter
@NoArgsConstructor
public class ChatroomUserId implements Serializable {
    private Long chatroomId;
    private Long userId;
}
