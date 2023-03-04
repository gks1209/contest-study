package com.example.conteststudy.domain.dto;

import com.example.conteststudy.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private String student_id;
    private String password;
    private String name;
    private String nickname;
    private boolean graduate;
    private String major1;
    private String major2;
    private boolean department;
    private boolean major_minor;
    private boolean double_major;
    private double grades;
    private boolean status;
    private int semester;

    public User toEntity() {
        return User.builder().student_id(student_id).password(password).name(name).nickname(nickname)
                .graduate(graduate).major1(major1).major2(major2).department(department).major_minor(major_minor)
                .double_major(double_major).grades(grades).status(status).semester(semester).build();
    }
}
