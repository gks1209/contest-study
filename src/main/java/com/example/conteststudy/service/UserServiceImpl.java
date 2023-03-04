package com.example.conteststudy.service;

import com.example.conteststudy.domain.User;
import com.example.conteststudy.domain.dto.UserDto;
import com.example.conteststudy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void save(UserDto userDto) {
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encodedPassword);
        userRepository.save(userDto.toEntity());
    }

    @Override
    public String login(String student_id, String password) {
        Optional<User> user = userRepository.findById(student_id);
        if(user.get().getPassword().equals(password)) {
            return "Success";
        }
        return "Failed";
    }
}
