package com.codingShuttle.projects.lovable_clone.service;

import com.codingShuttle.projects.lovable_clone.dto.AuthResponse;
import com.codingShuttle.projects.lovable_clone.dto.LoginRequest;
import com.codingShuttle.projects.lovable_clone.dto.SignUpRequest;

public interface AuthService {
    AuthResponse signup(SignUpRequest request);
    //above method returns authResponse (response dto) and signUpRequest is the (requestDto)


    AuthResponse login(LoginRequest request);
}
