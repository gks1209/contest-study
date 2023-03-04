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
@Table(name = "Evaluation")
public class Evaluation {
    @ManyToMany(mappedBy = "Evaluation")
    private List<User> user = new ArrayList<>();

    @Id //pk
    private String evaluation_id;

    @Column(length = 15)
    private String lecture_name;

    @Column(length = 15)
    private String prfs_name;

    @Column
    private int class_year;

    @Column(length = 15)
    private String my_semester;

    @Column
    private boolean team_play;

    @Column
    private int practice;

    @Column
    private boolean announcement;

    @Column
    private String review;

    @Column
    private boolean recommend;

    @Column
    private int star;



}
