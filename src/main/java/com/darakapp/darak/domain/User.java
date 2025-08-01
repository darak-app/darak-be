package com.darakapp.darak.domain;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               // getter, setter, toString, equals, hashCode 자동 생성
@NoArgsConstructor  // 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드 포함 생성자 자동 생성
public class User {
    private int id;                     // PK, auto_increment
    private String username;            // unique, not null
    private String name;                // not null
    private Integer age;                // nullable
    private Gender gender;              // enum('M','F','O'), nullable, default 'O'
    private String role;                // nullable
    private Timestamp createdAt;       // nullable, default CURRENT_TIMESTAMP

    public enum Gender {
        M, F, O
    }
}