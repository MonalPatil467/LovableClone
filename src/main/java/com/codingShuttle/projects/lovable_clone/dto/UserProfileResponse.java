package com.codingShuttle.projects.lovable_clone.dto;

public record UserProfileResponse(
        Long id,
        String email,
        String name,
        String avatarUrl

) {
}
