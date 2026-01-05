package com.codingShuttle.projects.lovable_clone.service.impl;

import com.codingShuttle.projects.lovable_clone.dto.AuthResponse;
import com.codingShuttle.projects.lovable_clone.dto.LoginRequest;
import com.codingShuttle.projects.lovable_clone.dto.SignUpRequest;
import com.codingShuttle.projects.lovable_clone.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceimpl implements AuthService {
    @Override
    public AuthResponse signup(SignUpRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
