package com.codingShuttle.projects.lovable_clone.controller;

import com.codingShuttle.projects.lovable_clone.dto.AuthResponse;
import com.codingShuttle.projects.lovable_clone.dto.LoginRequest;
import com.codingShuttle.projects.lovable_clone.dto.SignUpRequest;
import com.codingShuttle.projects.lovable_clone.dto.UserProfileResponse;
import com.codingShuttle.projects.lovable_clone.service.AuthService;
import com.codingShuttle.projects.lovable_clone.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(makeFinal = true, level=AccessLevel.PRIVATE)
public class AuthController {

 AuthService authService;

 UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignUpRequest request){
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(){
        Long userId=1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }

}