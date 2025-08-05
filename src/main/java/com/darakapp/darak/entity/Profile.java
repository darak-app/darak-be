package com.darakapp.darak.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "profiles")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String quote;
    private String bio;
    private String interests;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "images")
    private Image image;
}
