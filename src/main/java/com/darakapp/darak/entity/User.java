package com.darakapp.darak.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @Column(unique = true)
    private String username;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private UserGender gender;

    private String passwordHash;
    private String phoneNumberHash;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Builder
    public User(
            String username, String email, String nickname,
            String passwordHash, UserGender gender,  String phoneNumberHash
    ) {
        this.username = username;
        this.email = email;
        this.nickname = nickname;
        this.passwordHash = passwordHash;
        this.phoneNumberHash = phoneNumberHash;
        this.gender = gender;
    }
}
