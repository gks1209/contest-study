package com.example.conteststudy.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "User")
public class User {
    @ManyToMany
    @JoinTable(name = "USER_EVALUATION")
    private List<Evaluation> evaluations = new ArrayList<>();

    @Id //pk
    private String student_id; //학번

    @Column(length = 15)
    private String password; //비밀번호

    @Column(length = 10)
    private String name; //이름

    @Column(length = 15)
    private String nickname; //닉네임

    private boolean graduate; //졸업여부

    @Column(length = 15)
    private String major1; //전공1

    @Column(length = 15)
    private String major2; //전공2

    private boolean department; //학부
    private boolean major_minor; //주부전공
    private boolean double_major; //복수전공
    private double grades; //평균학점
    private boolean status; //이메일 인증 여부
    private int semester; //학기
}
