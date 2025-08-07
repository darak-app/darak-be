package com.darakapp.darak.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Getter
@NoArgsConstructor
class FriendId implements Serializable {
    private Long requesterId;
    private Long accepterId;
}