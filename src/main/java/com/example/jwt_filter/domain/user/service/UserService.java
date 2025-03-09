package com.example.jwt_filter.domain.user.service;

import com.example.jwt_filter.domain.user.dto.UserResponse;
import com.example.jwt_filter.domain.user.entity.User;
import com.example.jwt_filter.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponse save(String email) {
        //존재하면 가입할 수 없음. email = unique
        if (userRepository.existByEmail(email)) {
            throw new IllegalStateException("이미 가입된 이메일 입니다.");
        }

        User user = new User(email);
        User savedUser = userRepository.save(user);
        return new UserResponse(savedUser.getId(), savedUser.getEmail());
    }

    @Transactional(readOnly = true)
    public UserResponse findByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 유저입니다.")
        );
        return new UserResponse(user.getId(), user.getEmail());
    }
}