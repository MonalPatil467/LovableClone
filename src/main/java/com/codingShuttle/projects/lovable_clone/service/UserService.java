package com.codingShuttle.projects.lovable_clone.service;

import com.codingShuttle.projects.lovable_clone.dto.UserProfileResponse;
import jakarta.annotation.Nullable;

public interface UserService {
    @Nullable
    UserProfileResponse getProfile(Long userId);
}
