package com.thnoh.spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

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

    //@NotNull(message="The year cannot be empty")
    private int year;

    //@NotNull(message="The semester cannot be empty")
    private int semester;

    //@NotEmpty(message="The subject cannot be empty")
    private String subject;

    //@NotEmpty(message="The division cannot be empty")
    private String division;

    //@NotNull(message="The credit cannot be empty")
    private int credit;
}

