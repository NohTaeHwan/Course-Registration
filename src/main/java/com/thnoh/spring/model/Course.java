package com.thnoh.spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_code")
    private int code; //과목코드

    //@NotEmpty(message="연도를 입력해주세요")
    private int year;

    private int semester;

    //@NotEmpty(message="과목명을 입력해주세요")
    private String subject;

    //@NotEmpty(message="The division cannot be empty")
    private String division;

    //@NotNull(message="The credit cannot be empty")
    private int credit;
}

