package com.codingShuttle.projects.lovable_clone.service.impl;

import com.codingShuttle.projects.lovable_clone.dto.UserProfileResponse;
import com.codingShuttle.projects.lovable_clone.error.ResourceNotFoundException;
import com.codingShuttle.projects.lovable_clone.repository.UserRepository;
import com.codingShuttle.projects.lovable_clone.service.UserService;
import jakarta.annotation.Nullable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    private UserRepository userRepository;
    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}
