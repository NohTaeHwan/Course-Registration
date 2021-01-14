package com.thnoh.spring.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @NotEmpty(message = "유저 아이디를 입력해주세요")
    private String username;

    @NotEmpty(message = "유저 비밀번호를 입력해주세요")
    private String password;

    //private String division;//학과

    //private int grade;//학년

    private boolean enabled = false;//사용자 계정 활성 정보 true false

    private String authority;

}
