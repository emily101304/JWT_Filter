package com.example.jwt_filter.domain.auth.service;

import com.example.jwt_filter.domain.auth.dto.SigninRequest;
import com.example.jwt_filter.domain.auth.dto.SigninResponse;
import com.example.jwt_filter.domain.auth.dto.SignupRequest;
import com.example.jwt_filter.domain.auth.dto.SignupResponse;
import com.example.jwt_filter.domain.config.JwtUtil;
import com.example.jwt_filter.domain.user.dto.UserResponse;
import com.example.jwt_filter.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Transactional
    public SignupResponse signup(SignupRequest request) {
        UserResponse saveResult = userService.save(request.getEmail());

        String bearerJwt = jwtUtil.createToken(saveResult.getId(), saveResult.getEmail());
        return new SignupResponse(bearerJwt);
    }

    @Transactional(readOnly = true)
    public SigninResponse signin(SigninRequest request) {
        UserResponse userResult = userService.findByEmail(request.getEmail());
        String bearerJwt = jwtUtil.createToken(userResult.getId(), userResult.getEmail());
        return new SigninResponse(bearerJwt);
    }
}
