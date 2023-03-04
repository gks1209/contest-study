package com.example.conteststudy.controller;

import com.example.conteststudy.domain.dto.UserDto;
import com.example.conteststudy.domain.request.UserRequest;
import com.example.conteststudy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor //생성자 자동생성
public class UserController {
    private final UserService userService;

    @PostMapping("/users/new-user") //회원가입
    public ResponseEntity<String> join(@RequestBody UserDto userDto) { //Requestbody는 굳이 안적어도 됌
        userService.save(userDto);
        return ResponseEntity.ok("join success");
    }

    @PostMapping("/users/login") //로그인
    public ResponseEntity login(@RequestBody UserRequest request) {
        if (userService.login(request.getStudent_id(),
                request.getPassword()).equals("Success")) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
