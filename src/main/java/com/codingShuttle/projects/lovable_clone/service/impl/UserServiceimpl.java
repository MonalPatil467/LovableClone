package com.codingShuttle.projects.lovable_clone.service.impl;

import com.codingShuttle.projects.lovable_clone.dto.UserProfileResponse;
import com.codingShuttle.projects.lovable_clone.service.UserService;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}
