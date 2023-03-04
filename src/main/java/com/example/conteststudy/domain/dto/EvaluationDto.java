package com.example.conteststudy.domain.dto;

import com.example.conteststudy.domain.Evaluation;
import com.example.conteststudy.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EvaluationDto {

    private String evaluation_id;
    private String lecture_name;
    private String prfs_name;
    private int class_year;
    private String my_semester;
    private boolean team_play;
    private int practice;
    private boolean announcement;
    private String review;
    private boolean recommend;
    private int star;

    public Evaluation toEntity() {
        return Evaluation.builder().evaluation_id(evaluation_id).lecture_name(lecture_name).prfs_name(prfs_name)
                .class_year(class_year).my_semester(my_semester).team_play(team_play).practice(practice)
                .announcement(announcement).review(review).recommend(recommend).star(star).build();
    }

}
