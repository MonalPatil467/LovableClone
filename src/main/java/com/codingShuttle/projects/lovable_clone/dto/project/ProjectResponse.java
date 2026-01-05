package com.codingShuttle.projects.lovable_clone.dto.project;

import com.codingShuttle.projects.lovable_clone.dto.UserProfileResponse;

import java.time.Instant;

public record ProjectResponse(
        String name,
        Long id,
        Instant createdAt,
        Instant updatedAt,
        UserProfileResponse owner
) {
}
