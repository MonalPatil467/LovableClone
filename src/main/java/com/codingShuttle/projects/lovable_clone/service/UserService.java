package com.codingShuttle.projects.lovable_clone.service;

import com.codingShuttle.projects.lovable_clone.dto.UserProfileResponse;
import jakarta.annotation.Nullable;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    @Nullable
    UserProfileResponse getProfile(Long userId);
}


