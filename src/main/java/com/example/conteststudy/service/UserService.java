package com.example.conteststudy.service;

import com.example.conteststudy.domain.dto.UserDto;

public interface UserService {

    void save(UserDto userDto); //회원가입

    String login(String student_id, String password); //로그인
}
