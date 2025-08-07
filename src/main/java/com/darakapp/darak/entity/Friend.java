package com.darakapp.darak.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Table(name = "friends")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Friend {
    @EmbeddedId
    private FriendId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("requesterId")
    @JoinColumn(name = "requester_id")
    private User requesterId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("accepterId")
    @JoinColumn(name = "accepter_id")
    private User accepterId;

    @Enumerated(EnumType.STRING)
    private FriendStatus status;
}
