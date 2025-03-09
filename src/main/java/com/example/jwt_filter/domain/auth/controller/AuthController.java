package com.example.jwt_filter.domain.auth.controller;

import com.example.jwt_filter.domain.auth.dto.SigninRequest;
import com.example.jwt_filter.domain.auth.dto.SigninResponse;
import com.example.jwt_filter.domain.auth.dto.SignupRequest;
import com.example.jwt_filter.domain.auth.dto.SignupResponse;
import com.example.jwt_filter.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/singup")
    public SignupResponse signup(@RequestBody SignupRequest request) {
        return authService.signup(request);
    }

    @PostMapping("/auth/signin")
    public SigninResponse signin(@RequestBody SigninRequest request) {
        return authService.signin(request);
    }
}
